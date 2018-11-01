package com.projecteulersolvers.commandline;

public class CommandLineParseException extends RuntimeException {

	public CommandLineParseException() {
		super();
	}

	public CommandLineParseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommandLineParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandLineParseException(String message) {
		super(message);
	}

	public CommandLineParseException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -8025350885789954648L;

}
