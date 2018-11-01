package com.projecteulersolvers.service;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.projecteulersolvers.service.problemparameters.Problem8Parameters;

public class Problem8SolverTests {
	
	@Test
	void defaultParameters() {
		Problem8Solver solver = new Problem8Solver();
		BigDecimal solution = solver.solve(new Problem8Parameters());
		assertEquals(new BigDecimal(23514624000l), solution);
	}
	
	@Test
	void nullParameters() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Problem8Solver solver = new Problem8Solver();
			solver.solve(null); 
		});
	}
	
	@Test
	void subsequenceLengthLessThan2() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Problem8Solver solver = new Problem8Solver();
			Problem8Parameters parameters = new Problem8Parameters();
			parameters.setSubsequenceLength(1);
			solver.solve(parameters); 
		});
	}
	
	@Test
	void nullSequence() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Problem8Solver solver = new Problem8Solver();
			Problem8Parameters parameters = new Problem8Parameters();
			parameters.setSubsequenceLength(100);
			parameters.setSequence(null);
			solver.solve(parameters); 
		});
	}
	
	@Test
	void subsequenceLengthLessThanSequenceLength() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Problem8Solver solver = new Problem8Solver();
			Problem8Parameters parameters = new Problem8Parameters();
			parameters.setSubsequenceLength(4);
			parameters.setSequence("123");
			solver.solve(parameters); 
		});
	}
	
	@Test
	void nonNumericSequence() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Problem8Solver solver = new Problem8Solver();
			Problem8Parameters parameters = new Problem8Parameters();
			parameters.setSubsequenceLength(100);
			parameters.setSequence("123AB123");
			solver.solve(parameters); 
		});
	}
	
	@Test
	void minimumLengthSequence() {
		Problem8Solver solver = new Problem8Solver();
		Problem8Parameters parameters = new Problem8Parameters();
		parameters.setSubsequenceLength(2);
		parameters.setSequence("22");
		BigDecimal solution = solver.solve(parameters);
		assertEquals(new BigDecimal(4), solution);
	}
	
	
	

}
