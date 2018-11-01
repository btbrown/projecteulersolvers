package com.projecteulersolvers.service;

import java.math.BigDecimal;

import com.projecteulersolvers.service.problemparameters.ProblemParameters;

/**
 * 
 * Generic Interface for a Solver service which implements a solution to a given
 * specifc problem cataloged on Project Euler.
 *
 * @param <T> The implementation of the applicable ProblemParameters class
 */
public interface ProblemSolver<T extends ProblemParameters> {
	
	public BigDecimal solve(T parameters);
	
}
