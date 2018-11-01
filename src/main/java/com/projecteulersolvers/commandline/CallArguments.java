package com.projecteulersolvers.commandline;

import java.util.List;

/**
 * Value object storing the parsed results of a command line invocation.
 * Currently this just holds the list of solve requests, but it will be a
 * container for other arguments the command line may support in the future.
 *
 */
public class CallArguments {
	
	
	List<SolveProblemRequest> solveProblemRequests;
	
	public List<SolveProblemRequest> getSolveProblemRequests() {
		return solveProblemRequests;
	}

	public void setSolveProblemRequests(List<SolveProblemRequest> solveProblemRequests) {
		this.solveProblemRequests = solveProblemRequests;
	}

}
