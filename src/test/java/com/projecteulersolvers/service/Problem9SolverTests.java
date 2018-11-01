package com.projecteulersolvers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.projecteulersolvers.service.problemparameters.Problem9Parameters;


public class Problem9SolverTests {

	
	/**
	 * The default parameters on each ProblemParameter implementation will yield the answer for
	 * the problem as stated on the project euler website.
	 */
	@Test
	void defaultParameters() {
		Problem9Solver solver = new Problem9Solver();
		BigDecimal solution = solver.solve(new Problem9Parameters());
		assertEquals(new BigDecimal(31875000), solution);
	}
	
	@Test
	void nullParameters() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Problem9Solver solver = new Problem9Solver();
			solver.solve(null); 
		});
	}
	
	@Test
	void basicNonDefaultValue() {
		Problem9Solver solver = new Problem9Solver();
		Problem9Parameters p9p = new Problem9Parameters();
		p9p.setTargetSum(12);
		BigDecimal solution = solver.solve(p9p);
		assertEquals(new BigDecimal(60), solution);
	}
	
	@Test
	void noSolutionTest() {
		Problem9Solver solver = new Problem9Solver();
		Problem9Parameters p9p = new Problem9Parameters();
		p9p.setTargetSum(13);
		BigDecimal solution = solver.solve(p9p);
		assertEquals(null,solution);
	}
	

}
