package com.picavi.jsonrpc.validator;

import org.springframework.stereotype.Component;

import com.picavi.jsonrpc.exception.InvalidRequestException;
import com.picavi.jsonrpc.model.Request;

@Component
public class JsonRpcRequestValidator {

	private static final String VERSION = "2.0";

	public void validateRequest(Request request) {
		if (request != null) {
			if (!request.getJsonrpc().equals(VERSION))
				throw new InvalidRequestException("Invalid Request");

			else if (request.getMethod().startsWith("rpc."))
				throw new InvalidRequestException("Invalid Request");

			else if (request.getId().isNull())
				throw new InvalidRequestException(
						"Invalid Request");
		}
	}
}
