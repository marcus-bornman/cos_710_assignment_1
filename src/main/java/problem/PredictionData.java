package problem;

import ec.gp.GPData;

public class PredictionData extends GPData {
	public double num;

	@Override
	public void copyTo(final GPData gpd) {
		((PredictionData) gpd).num = num;
	}
}
