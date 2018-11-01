package com.projecteulersolvers.service.problemparameters;

/**
 * Factory for producing appropriate instances of ProblemParameters implementors
 * for a given problem.
 */
public interface ProblemParametersFactory {

	public ProblemParameters createProblemParameters(String problemId);

	public ProblemParameters createProblemParameters(String problemId, String[] args);

}
