package com.picavi.jsonrpc.exception;

public class RPCMethodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RPCMethodNotFoundException(String message) {
		super(message);
	}

	public RPCMethodNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RPCMethodNotFoundException(Throwable cause) {
		super(cause);
	}
}
