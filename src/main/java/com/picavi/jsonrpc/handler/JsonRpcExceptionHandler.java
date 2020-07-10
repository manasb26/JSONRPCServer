package com.picavi.jsonrpc.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.picavi.jsonrpc.exception.InternalException;
import com.picavi.jsonrpc.exception.InvalidMethodParameterException;
import com.picavi.jsonrpc.exception.InvalidRequestException;
import com.picavi.jsonrpc.exception.RPCMethodNotFoundException;
import com.picavi.jsonrpc.model.ErrorMessage;
import com.picavi.jsonrpc.model.ErrorResponse;

@ControllerAdvice
public class JsonRpcExceptionHandler {
	
	private static final int INVALID_REQUEST_CODE = -32600;
	private static final int METHOD_NOT_FOUND_CODE = -32601;
	private static final int INVALID_PARAMS_CODE = -32602;
	private static final int INTERNAL_ERROR_CODE = -32603;
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(InvalidRequestException exception) {
		ErrorMessage error = new ErrorMessage(INVALID_REQUEST_CODE, exception.getMessage(), null);
		ErrorResponse errorResponse = new ErrorResponse(error);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(RPCMethodNotFoundException exception) {
		ErrorMessage error = new ErrorMessage(METHOD_NOT_FOUND_CODE, exception.getMessage(), null);
		ErrorResponse errorResponse = new ErrorResponse(error);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(InvalidMethodParameterException exception) {
		ErrorMessage error = new ErrorMessage(INVALID_PARAMS_CODE, exception.getMessage(), null);
		ErrorResponse errorResponse = new ErrorResponse(error);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(InternalException exception) {
		ErrorMessage error = new ErrorMessage(INTERNAL_ERROR_CODE, exception.getMessage(), null);
		ErrorResponse errorResponse = new ErrorResponse(error);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {
		ErrorMessage error = new ErrorMessage(INTERNAL_ERROR_CODE, "Internal Error", null);
		ErrorResponse errorResponse = new ErrorResponse(error);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);		
	}

}
