package com.projecteulersolvers.service.problemparameters;

/**
 * Interface for value objects which contain the solution parameters for a given
 * invocation of a com.projecteulersolvers.service.ProblemSolver
 *
 */
public interface ProblemParameters {
	
	/**
	 * Convenience method to populate the attributes of the Parameters object from
	 * an array of Strings. Order is of course important see java doc of
	 * implementors.
	 * 
	 * @param args
	 */
	public void populate(String[] args);
	

}
