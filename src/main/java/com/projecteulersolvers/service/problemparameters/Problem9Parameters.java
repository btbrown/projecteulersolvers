package com.projecteulersolvers.service.problemparameters;

public class Problem9Parameters implements ProblemParameters {

	
	public static final int DEFAULT_TARGET_SUM = 1000;
	
	private int targetSum = DEFAULT_TARGET_SUM;
	
	
	public int getTargetSum() {
		return targetSum;
	}


	public void setTargetSum(int targetSum) {
		this.targetSum = targetSum;
	}

	/**
	 * @param args Expects one numeric String representing an Integer ( range
	 *             -2,147,483,648 to 2,147,483,647 ) in the first index representing
	 *             the target sum of the a, b and c terms of the Pythagorean
	 *             triplet. The string should have no commas or delimiters.
	 * 
	 */
	public void populate(String[] args) {
		if(args != null && args.length > 0) {
			try {
				this.setTargetSum(Integer.parseInt(args[0]));
			} catch(NumberFormatException e) {
				throw new IllegalArgumentException("Invalid argument value: " + args[0] + " for parameter targetSum", e);
			}
		}
		
	}
	
	
	
}
