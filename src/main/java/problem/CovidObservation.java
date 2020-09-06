package problem;

import java.time.LocalDate;

public class CovidObservation {
	public final int serial;
	public final LocalDate date;
	public final String province;
	public final String country;
	public final double confirmed;
	public final double deaths;
	public final double recovered;

	public CovidObservation(int serial, LocalDate date, String province, String country, double confirmed, double deaths, double recovered) {
		this.serial = serial;
		this.date = date;
		this.province = province;
		this.country = country;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
	}
}
