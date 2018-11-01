package com.projecteulersolvers.commandline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONStyleCommandLineParser implements CommandLineParser {

	/**
	 * This method will parse the raw command line arguments expressed in an
	 * expected JSON format into value objects for processing by the application.
	 * 
	 * @param args The raw command line parameters. This parser expects command
	 *             lines of the form: -problems "<json string>" or -problemsFile
	 *             <filepath to json file>. For the former, the JSON string entered
	 *             on the command line should be quoted to allow for any whitespace.
	 *             Property names do not need to be quoted. The json contains the
	 *             information for the solvers to operate. It is in the form of an
	 *             array of objects with a problemId property which corresponds to
	 *             the Project Euler problem id to solve and an array of arguments
	 *             named "args" which will be parsed into the fields of the
	 *             appropriate ProblemParameters implementation according to the
	 *             documentation on its
	 *             {@link com.projecteulersolvers.service.problemparameters.ProblemParameters#populate}
	 *             method. See src/main/resources/SampleProblemsFile.txt for an
	 *             example of a valid problems file to invoke solving problems 8, 9
	 *             and 10.
	 * 
	 *             Example command line: -problems "[{problemId:10,args:[1000]}]"
	 * 
	 * 
	 * @return CallArguments a container value object holding the parsed command
	 *         line arguments.
	 * @throws CommandLineParseException if there is an issue with parsing the
	 *                                   command line arguments, either they are
	 *                                   malformed or the 'problemsFile' is not
	 *                                   accessible.
	 */
	public CallArguments parseCommandLine(String[] args) {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		CallArguments callArgs = new CallArguments();

		for (int i = 0; i < args.length; i++) {

			if (args[i].equalsIgnoreCase("-problems")) {
				String problemIdsArg = args[++i];
				SolveProblemRequest[] requests;
				try {
					requests = objectMapper.readValue(problemIdsArg, SolveProblemRequest[].class);
					callArgs.setSolveProblemRequests(Arrays.asList(requests));
				} catch (Exception e) {
					throw new CommandLineParseException(
							"An error occurred reading the provided command line parameters. Please check for malformed input",
							e);
				}

			} else if (args[i].equalsIgnoreCase("-problemsFile")) {
				String filePath = args[++i];
				Path path = Paths.get(filePath);
				SolveProblemRequest[] requests;

				try {
					byte[] fileBytes = Files.readAllBytes(path);
					requests = objectMapper.readValue(fileBytes, SolveProblemRequest[].class);
					callArgs.setSolveProblemRequests(Arrays.asList(requests));
				} catch (IOException e) {
					throw new CommandLineParseException(
							"An error occurred reading the problems file. Please check that the file exists, is accessible and has no malformed content.",
							e);
				}

			}

		}

		return callArgs;

	}

}
