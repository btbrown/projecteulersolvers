package com.projecteulersolvers.service.problemparameters;

public class Problem10Parameters implements ProblemParameters {

	public static final int DEFAULT_SUM_PRIMES_TO = 2000000;

	private int sumPrimesTo = DEFAULT_SUM_PRIMES_TO;

	public int getSumPrimesTo() {
		return sumPrimesTo;
	}

	public void setSumPrimesTo(int sumPrimesTo) {
		this.sumPrimesTo = sumPrimesTo;
	}

	/**
	 * @param args Expects one numeric String representing an Integer ( range
	 *             -2,147,483,648 to 2,147,483,647 ) in the first index representing
	 *             the upper bound below which all the primes will be summed in the
	 *             first index. The string should have no commas or delimiters.
	 */
	public void populate(String[] args) {
		if (args != null && args.length > 0) {
			try {
				this.setSumPrimesTo(Integer.parseInt(args[0]));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Invalid argument value: " + args[0] + " for parameter sumPrimesTo",
						e);
			}
		}
	}

}
