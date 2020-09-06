package nodes;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.*;
import ec.util.Code;
import problem.PredictionData;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class R extends ERC {
	public double value;

	@Override
	public String name() {
		return "R";
	}

	@Override
	public String toStringForHumans() {
		return "R" +  String.format("%.2f", value);
	}

	@Override
	public String encode() {
		return Code.encode(value);
	}

	@Override
	public void resetNode(EvolutionState state, int thread) {
		value = state.random[thread].nextDouble();
	}

	@Override
	public boolean nodeEquals(GPNode gpNode) {
		return gpNode.getClass().equals(R.class) && ((R) gpNode).value == this.value;
	}

	@Override
	public void readNode(EvolutionState state, DataInput input) throws IOException {
		value = input.readDouble();
	}

	@Override
	public void writeNode(EvolutionState state, DataOutput output) throws IOException {
		output.writeDouble(value);
	}

	@Override
	public void mutateERC(EvolutionState state, int thread) {
		double v;
		do v = value + state.random[thread].nextGaussian() * 0.01;
		while (v < 0.0 || v >= 1.0);
		value = v;
	}

	@Override
	public void eval(final EvolutionState state, final int thread, final GPData input, final ADFStack stack, final GPIndividual individual, final Problem problem) {
		((PredictionData) input).num = value;
	}
}
