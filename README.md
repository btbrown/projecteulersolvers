

Introduction:
-------------

This is a command line application that given a set of parameters will produce solutions to problems cataloged in 
Project Euler (https://projecteuler.net/). The solutions to the problems as well as the run time in ms will be output
to the console.

The application was built with extensibility in mind, making it easy to add to its library of solution implementations 
for the purpose of solving new problems, or adding alternative algorithms for problems with existing solutions.

Currently the application implements solutions to problems 8, 9 and 10 of Project Euler.

These implementations are designed to work with arbitraty parameters and so they solve not just the problems stated
exactly as they are in the Euler Project, but problems of that general form.



Getting Started:
----------------

The final packaged version of the application is a single executable JAR file.

A pre-built version of this can be found in the /bin directory of the repository

The command line parameters specify which problems to solve and parameters for those problems using json notation.

The json can be specified on the command line or instead a path to a file containing the json can be specified instead.

Example of command line direct (from root of repository):
java -jar bin/project-euler-solvers-1.0.0-runnable.jar -problems "[{problemId:10,args:[2000000]}]"

Example of file input:
java -jar bin/project-euler-solvers-1.0.0-runnable.jar -problemsFile samples/SampleProblemsFile.txt

*Note see the javadoc (under the documentation folder at root of the repository) for the populate method of implementors 
of ProblemParameters regarding details on the expected arguments specific to each problem.
For example, documentation/javadoc/com/projecteulersolvers/service/problemparameters/Problem10Parameters.html

*Note that for command line direct, the json string should be quoted to avoid parsing issues due to white space.

*Note also, that the standard convention that the json property names be double quoted in properly formed json has been 
relaxed for convenience.

*Note that the parameters can have a drastic effect on the runtime of the application and the application will block as
the solvers work. Multi-threading would be a nice enhancement for a future release :)

See the samples directory for a Sample problems file ("SampleProblemsFile.txt") and sample output 
("SampleProblemsFileOutput.txt")



Notices:
--------

This app uses the following third party libraries:

Apache Commons Math (http://commons.apache.org/proper/commons-math/) under the Apache License (http://www.apache.org/licenses/LICENSE-2.0.html)
Apache Log4j (https://logging.apache.org/log4j/2.x/) under the Apache License (https://logging.apache.org/log4j/2.x/license.html)
Jackson (https://github.com/FasterXML/jackson) under the Apache License (http://www.apache.org/licenses/LICENSE-2.0.html)
The Spring Framework (https://spring.io) under the Apache License (http://www.apache.org/licenses/LICENSE-2.0.html)



