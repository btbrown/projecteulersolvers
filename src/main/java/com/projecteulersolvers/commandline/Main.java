package com.projecteulersolvers.commandline;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projecteulersolvers.service.Problem;
import com.projecteulersolvers.service.ProblemSolver;
import com.projecteulersolvers.service.problemparameters.ProblemParameters;
import com.projecteulersolvers.service.problemparameters.ProblemParametersFactory;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

	/**
	 * This method will accept from the command line instructions to solve problems
	 * cataloged at Project Euler (https://projecteuler.net) outputting the results
	 * to the console or log file as configured by log4j
	 * 
	 * @param args The raw command line arguments. Expectations of the format depend
	 *             on the
	 *             {@link com.projecteulersolvers.commandline.CommandLineParser}
	 *             implementation that's been injected. Refer to the documentation
	 *             on the implementor.
	 */
	public static void main(String[] args) {

		// TODO Change these message strings to read from resource bundles...
		LOGGER.info("Initializing application...");

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("services.xml");

		try {

			CommandLineParser parser = ctx.getBean("commandLineParser", CommandLineParser.class);
			CallArguments callArgs = parser.parseCommandLine(args);

			if (callArgs.getSolveProblemRequests() != null) {

				ProblemParametersFactory problemParametersFactory = ctx.getBean("problemParametersFactory",
						ProblemParametersFactory.class);

				for (SolveProblemRequest rq : callArgs.getSolveProblemRequests()) {
					
					@SuppressWarnings("unchecked")
					Map<String, ProblemSolver<ProblemParameters>> solverDirectory = (Map<String, ProblemSolver<ProblemParameters>>) ctx
							.getBean("solverDirectory", Map.class);
					ProblemSolver<ProblemParameters> service = solverDirectory.get(rq.getProblemId());

					if (service == null) {
						LOGGER.info("No implementation configured to solve problem ID: " + rq.getProblemId()
								+ " skipping ...");
						continue;
					}

					try {
						
						LOGGER.info("Start solve for problem Id: " + rq.getProblemId() + " '"
								+ Problem.getDescriptionByID(rq.getProblemId()) + "'");
						
						ProblemParameters p = problemParametersFactory.createProblemParameters(rq.getProblemId(),
								rq.getArgs());
						
						long start = System.currentTimeMillis();
						//Would be a nice enhancement to run this in a separate thread with a timeout and write progress to the console.
						BigDecimal val = service.solve(p);
						long end = System.currentTimeMillis();
						
						LOGGER.info("Solved problem id: " + rq.getProblemId() + " '"
								+ Problem.getDescriptionByID(rq.getProblemId()) + "' with result: "
								+ val.toPlainString() + " taking " + (end - start) + " millisecond(s)");
						
					} catch (RuntimeException e) {
						LOGGER.error("Error trying to solve problem id: " + rq.getProblemId() + " '"
								+ Problem.getDescriptionByID(rq.getProblemId()) + "' problem was '" + e.getMessage()
								+ "'");
						LOGGER.debug(e.getMessage(), e);
					}
				}
			}

		} catch (CommandLineParseException e) {

			LOGGER.error(e.getMessage());
			LOGGER.debug(e.getMessage(), e);

		} catch (Exception e) {
			LOGGER.error("An unexpected error has occurred. The application will now terminate.");
			LOGGER.debug(e.getMessage(), e);
		}

		ctx.close();
		LOGGER.info("Application finished.");

	}

}
