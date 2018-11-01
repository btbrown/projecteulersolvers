package com.projecteulersolvers.service;

import java.math.BigDecimal;

import com.projecteulersolvers.service.problemparameters.Problem9Parameters;

public class Problem9Solver implements ProblemSolver<Problem9Parameters> {

	/**
	 * Solves problems in the form of problem 9 of Project Euler (https://projecteuler.net/problem=9)
	 * 
	 * @return The solution to problem 9 or null if no solution can be found.
	 * @throws IllegalArgumentException if the parameters object passed in is null
	 */
	public BigDecimal solve(Problem9Parameters parameters) {

		validateParameters(parameters);

		int targetSum = parameters.getTargetSum();


		for (int b = 1; b < targetSum; b++) {
			for (int a = 1; a < b; a++) {

				// algebraic substitution of c using the system of equations a^2 + b^2 = c^2 and a+b+c=targetSum
				if ((a * a + b * b) == Math.pow((targetSum - a - b), 2)) {
					int c = targetSum - a - b;
					
					BigDecimal product = (new BigDecimal(c)).multiply(new BigDecimal(b)).multiply(new BigDecimal(a));
					
					return product;
				}

			}

		}

		return null; 
	}

	private void validateParameters(Problem9Parameters parameters) {
		if (parameters == null) {
			throw new IllegalArgumentException("ProblemParameters cannot be null");
		}
	}

}
