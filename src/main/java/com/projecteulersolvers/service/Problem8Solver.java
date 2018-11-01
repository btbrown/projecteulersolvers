package com.projecteulersolvers.service;

import java.math.BigDecimal;

import com.projecteulersolvers.service.problemparameters.Problem8Parameters;

public class Problem8Solver implements ProblemSolver<Problem8Parameters> {

	/**
	 * Solves problems in the form of problem 8 of Project Euler (https://projecteuler.net/problem=8)
	 * 
	 * Negative digits are not supported and will trigger an error.
	 * 
	 * @throws IllegalArgumentException if:
	 * <ul>
	 * <li>The parameters object passed in is null
	 * <li>If subsequenceLength <= 1
	 * <li>If the sequence is not specified
	 * <li>If subsequenceLength is longer than the sequence
	 * <li>If the sequence contains non-numeric characters.
	 * </ul>
	 */
	public BigDecimal solve(Problem8Parameters parameters) {
		
		validateParameters(parameters);
		
		String seq = parameters.getSequence();
		int seqLen = parameters.getSubsequenceLength();
		
		char[] seqchars = seq.toCharArray();
		
		int startIdx = 0;
		int endIdx = seqLen - 1;
		
		BigDecimal biggestProduct = BigDecimal.ZERO;
		
		while(endIdx < seqchars.length) {
			
			BigDecimal sum = multRange(seqchars, startIdx, endIdx);
			if(sum.compareTo(biggestProduct) == 1) {
				biggestProduct = sum;
			}
			
			startIdx += 1;
			endIdx += 1;
		}
		
		return biggestProduct;
		
	}

	
	private BigDecimal multRange(char[] sequence, int start, int end) {
		
		BigDecimal product = new BigDecimal(Character.getNumericValue(sequence[start]));
		for(int i=start+1; i<=end; i++) {
			product = product.multiply(new BigDecimal(Character.getNumericValue(sequence[i])));
		}
		
		return product;
		
	}
	
	private void validateParameters(Problem8Parameters parameters) {
		if(parameters == null) {
			throw new IllegalArgumentException("ProblemParameters cannot be null");
		}
		if(parameters.getSubsequenceLength() <= 1) {
			throw new IllegalArgumentException("Subsequence length must be greater than 1");
		}
		if(parameters.getSequence() == null || parameters.getSequence().trim().length() == 0) {
			throw new IllegalArgumentException("Sequence not specified");
		}
		if(parameters.getSubsequenceLength() > parameters.getSequence().length()) {
			throw new IllegalArgumentException("Subsequence length must not be greater than the length of the sequence");
		}
		if(parameters.getSequence().matches("![0-9]")) {
			throw new IllegalArgumentException("Sequence must contain numbers only");
		}
	}


}
