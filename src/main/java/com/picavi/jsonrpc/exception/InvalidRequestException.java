package com.picavi.jsonrpc.exception;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidRequestException(String message) {
		super(message);
	}

	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRequestException(Throwable cause) {
		super(cause);
	}

}
