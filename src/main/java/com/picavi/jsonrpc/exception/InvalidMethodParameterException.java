package com.picavi.jsonrpc.exception;

public class InvalidMethodParameterException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidMethodParameterException(String message) {
		super(message);
	}

	public InvalidMethodParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMethodParameterException(Throwable cause) {
		super(cause);
	}

}
