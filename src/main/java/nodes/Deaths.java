package nodes;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import problem.CovidProblem;
import problem.PredictionData;

import java.time.LocalDate;
import java.time.Period;

public class Deaths extends GPNode {
	@Override
	public String toString() {
		return "D";
	}

	@Override
	public int expectedChildren() {
		return 1;
	}

	@Override
	public void eval(final EvolutionState state, final int thread, final GPData input, final ADFStack stack, final GPIndividual individual, final Problem problem) {
		PredictionData data = ((PredictionData) (input));

		children[0].eval(state, thread, input, stack, individual, problem);
		double daysBeforeCurrent = Math.floor(data.num * ((CovidProblem) problem).windowSize) + 1;

		LocalDate date = ((CovidProblem) problem).date.minus(Period.ofDays((int) daysBeforeCurrent));
		LocalDate dayBeforeDate = date.minus(Period.ofDays(1));

		data.num = ((CovidProblem) problem).dateToDeathsMap.get(date) - ((CovidProblem) problem).dateToDeathsMap.get(dayBeforeDate);
	}
}

