package com.projecteulersolvers.commandline;

/**
 * Value object storing the details of a parsed command line argument
 * representing a request for a problem to be solved on this invocation.
 */
public class SolveProblemRequest {
	
	String problemId;
	
	String[] args;

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}
	
	

}
