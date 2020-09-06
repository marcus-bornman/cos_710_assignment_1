/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/


package nodes;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import problem.PredictionData;

public class Add extends GPNode {
	public String toString() {
		return "+";
	}

	public int expectedChildren() {
		return 2;
	}

	public void eval(final EvolutionState state, final int thread, final GPData input, final ADFStack stack, final GPIndividual individual, final Problem problem) {
		double result;
		PredictionData data = ((PredictionData) (input));

		children[0].eval(state, thread, input, stack, individual, problem);
		result = data.num;

		children[1].eval(state, thread, input, stack, individual, problem);
		data.num = result + data.num;
	}
}

