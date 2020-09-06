package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
	public List<CovidObservation> readTrainingData(String filename) throws IOException {
		List<CovidObservation> observations = new ArrayList<>();
		InputStream inputStream = getClass().getResourceAsStream(filename);

		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		br.readLine();//to get rid of headers
		while ((line = br.readLine()) != null) {
			String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

			int serial = Integer.parseInt(data[0]);
			LocalDate observationDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			String province = data[2];
			String country = data[3];
			double confirmed = Double.parseDouble(data[5]);
			double deaths = Double.parseDouble(data[6]);
			double recovered = Double.parseDouble(data[7]);

			CovidObservation observation = new CovidObservation(serial, observationDate, province, country, confirmed, deaths, recovered);
			observations.add(observation);
		}

		return observations;
	}
}
