package com.projecteulersolvers.service;

import java.math.BigDecimal;

import org.apache.commons.math3.primes.Primes;
import com.projecteulersolvers.service.problemparameters.Problem10Parameters;

public class Problem10Solver implements ProblemSolver<Problem10Parameters> {

	/**
	 * 	
	 * Solves problems in the form of problem 10 of Project Euler (https://projecteuler.net/problem=10)
	 * 
	 * @return The numeric solution. If the p.getSumPrimesTo is < 2, then this will return a zero.
	 * @throws IllegalArgumentException if the parameters object passed in is null
	 */
	public BigDecimal solve(Problem10Parameters parameters) {
		
		validateParameters(parameters);
		
		BigDecimal sum = BigDecimal.ZERO;

		for (int i = 0; i < parameters.getSumPrimesTo(); i++) {
			if (Primes.isPrime(i)) {
				sum = sum.add(new BigDecimal(i));
			}
		}
		
		return sum;
	}
	
	private void validateParameters(Problem10Parameters parameters) {
		if(parameters == null) {
			throw new IllegalArgumentException("ProblemParameters cannot be null");
		}
	}



}
