package com.projecteulersolvers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.projecteulersolvers.service.problemparameters.Problem10Parameters;

public class Problem10SolverTests {
	
	/**
	 * The default parameters on each ProblemParameter implementation will yield the answer for
	 * the problem as stated on the Project Euler website.
	 */
	@Test
	void defaultParameters() {
		Problem10Solver solver = new Problem10Solver();
		BigDecimal solution = solver.solve(new Problem10Parameters());
		assertEquals(new BigDecimal(142913828922l), solution);
	}
	
	@Test
	void nullParameters() {
		assertThrows(IllegalArgumentException.class, () -> { 
			Problem10Solver solver = new Problem10Solver();
			solver.solve(null); 
		});
	}
	
	@Test
	void negativeSumTo() {
		Problem10Solver solver = new Problem10Solver();
		Problem10Parameters p10p = new Problem10Parameters();
		p10p.setSumPrimesTo(-1);
		BigDecimal solution = solver.solve(p10p);
		assertEquals(BigDecimal.ZERO, solution);
	}
	
	@Test
	void sumToZero() {
		Problem10Solver solver = new Problem10Solver();
		Problem10Parameters p10p = new Problem10Parameters();
		p10p.setSumPrimesTo(0);
		BigDecimal solution = solver.solve(p10p);
		assertEquals(BigDecimal.ZERO, solution);
	}
	
	@Test
	void sumToOne() {
		Problem10Solver solver = new Problem10Solver();
		Problem10Parameters p10p = new Problem10Parameters();
		p10p.setSumPrimesTo(1);
		BigDecimal solution = solver.solve(p10p);
		//Zero, since 1 is not considered a prime number
		assertEquals(BigDecimal.ZERO, solution);
	}
	
	@Test
	void sumToTen() {
		Problem10Solver solver = new Problem10Solver();
		Problem10Parameters p10p = new Problem10Parameters();
		p10p.setSumPrimesTo(10);
		BigDecimal solution = solver.solve(p10p);
		assertEquals(new BigDecimal(17), solution);
	}
	

	

}
