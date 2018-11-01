package com.projecteulersolvers.service;

/**
 * Enumeration of the Project Euler problems with implemented
 * com.projecteulersolvers.service.ProblemSolvers
 *
 */
public enum Problem {

	PROBLEM_8("8", "Largest product in a series"),
	PROBLEM_9("9", "Special Pythagorean triplet"),
	PROBLEM_10("10", "Summation of primes");
	
	
	private final String ID;
	private final String description;
	
	Problem(String ID, String description) {
		this.ID = ID;
		this.description = description;
	}

	public String getID() {
		return ID;
	}

	public String getDescription() {
		return description;
	}
	
	public static String getDescriptionByID(String ID) {
		
		for(Problem e : values()) {
			if(e.getID().equals(ID)) return e.getDescription();
		}
		
		return null;
		
	}
	
	
}
