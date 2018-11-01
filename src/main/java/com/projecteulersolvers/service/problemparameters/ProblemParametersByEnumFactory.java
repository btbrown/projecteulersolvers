package com.projecteulersolvers.service.problemparameters;

import com.projecteulersolvers.service.Problem;

public class ProblemParametersByEnumFactory implements ProblemParametersFactory {
	
	public ProblemParameters createProblemParameters(String problemId) {
		return createProblemParameters(problemId, null);
	}
	
	public ProblemParameters createProblemParameters(String problemId, String[] args) {
		if(problemId.equals(Problem.PROBLEM_10.getID())) {
			Problem10Parameters p10 = new Problem10Parameters();
			p10.populate(args);
			return p10;
		} else if(problemId.equals(Problem.PROBLEM_9.getID())) {
			Problem9Parameters p9 = new Problem9Parameters();
			p9.populate(args);
			return p9;
		} else if(problemId.equals(Problem.PROBLEM_8.getID())) {
			Problem8Parameters p8 = new Problem8Parameters();
			p8.populate(args);
			return p8;
		}
		
		
		return null;
	}

}
