package problem;

import ec.EvolutionState;
import ec.Individual;
import ec.gp.GPIndividual;
import ec.gp.GPProblem;
import ec.gp.koza.KozaFitness;
import ec.simple.SimpleProblemForm;
import ec.util.Parameter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CovidProblem extends GPProblem implements SimpleProblemForm {
	private static final long serialVersionUID = 1;

	/**
	 * The current window size (in number of days) to consider.
	 */
	public int windowSize = 30;

	/**
	 * The current date to consider.
	 */
	public LocalDate date;

	/**
	 * The list of observations to use.
	 */
	public final List<CovidObservation> observations;

	/**
	 * A map with dates as keys and the number of confirmed cases as values.
	 */
	public final Map<LocalDate, Double> dateToConfirmedMap;

	/**
	 * A map with dates as keys and the number of confirmed cases as values.
	 */
	public final Map<LocalDate, Double> dateToDeathsMap;

	/**
	 * A map with dates as keys and the number of confirmed cases as values.
	 */
	public final Map<LocalDate, Double> dateToRecoveredMap;

	/**
	 * Reads the training data (COVID Observations) from training_data.csv to initialise the
	 * problem instance accordingly.
	 *
	 * @throws IOException if the file could not be read successfully.
	 */
	public CovidProblem() throws IOException {
		super();
		observations = new DataReader().readTrainingData("training_data.csv");
		dateToConfirmedMap = new HashMap<>();
		dateToDeathsMap = new HashMap<>();
		dateToRecoveredMap = new HashMap<>();
		for (CovidObservation observation : observations) {
			if (dateToConfirmedMap.containsKey(observation.date)) {
				dateToConfirmedMap.put(observation.date, dateToConfirmedMap.get(observation.date) + observation.confirmed);
				dateToDeathsMap.put(observation.date, dateToDeathsMap.get(observation.date) + observation.deaths);
				dateToRecoveredMap.put(observation.date, dateToRecoveredMap.get(observation.date) + observation.recovered);
			} else {
				dateToConfirmedMap.put(observation.date, observation.confirmed);
				dateToDeathsMap.put(observation.date, observation.deaths);
				dateToRecoveredMap.put(observation.date, observation.recovered);
			}
		}
	}

	@Override
	public void setup(final EvolutionState state, final Parameter base) {
		super.setup(state, base);

		if (!(input instanceof PredictionData)) {
			state.output.fatal("GPData class must subclass from " + PredictionData.class, base.push(P_DATA), null);
		}
	}

	@Override
	public void evaluate(final EvolutionState state, final Individual ind, final int subpopulation, final int threadnum) {
		if (ind.evaluated) return;

		PredictionData predictionData = (PredictionData) (this.input);
		LocalDate minDate = observations.get(0).date.plus(Period.ofDays(windowSize + 1));
		LocalDate maxDate = observations.get(observations.size() - 1).date.plus(Period.ofDays(1));
		long numDays = maxDate.toEpochDay() - minDate.toEpochDay();

		int hits = 0;
		double sum = 0.0;
		for (int i = 0; i < numDays; i++) {
			date = minDate.plus(Period.ofDays(i));

			((GPIndividual) ind).trees[0].child.eval(state, threadnum, predictionData, stack, ((GPIndividual) ind), this);
			double actualConfirmed = dateToConfirmedMap.get(date);
			double confirmedDiff = Math.abs(actualConfirmed - predictionData.num);

			((GPIndividual) ind).trees[1].child.eval(state, threadnum, predictionData, stack, ((GPIndividual) ind), this);
			double actualDeaths = dateToDeathsMap.get(date);
			double deathsDiff = Math.abs(actualDeaths - predictionData.num);

			((GPIndividual) ind).trees[2].child.eval(state, threadnum, predictionData, stack, ((GPIndividual) ind), this);
			double actualRecovered = dateToRecoveredMap.get(date);
			double recoveredDiff = Math.abs(actualRecovered - predictionData.num);

			double singleFitness = ((confirmedDiff / actualConfirmed) + (deathsDiff / actualDeaths) + (recoveredDiff / actualRecovered)) / 3;
			if (singleFitness < 0.05) hits++;
			sum += singleFitness;
		}

		((KozaFitness) ind.fitness).setStandardizedFitness(state, sum / numDays);
		((KozaFitness) ind.fitness).hits = hits;
		ind.evaluated = true;
	}
}

