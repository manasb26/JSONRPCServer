package com.picavi.jsonrpc.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.picavi.jsonrpc.config.RequestBroker;
import com.picavi.jsonrpc.exception.InternalException;
import com.picavi.jsonrpc.exception.InvalidMethodParameterException;
import com.picavi.jsonrpc.exception.RPCMethodNotFoundException;
import com.picavi.jsonrpc.model.ClassMetadata;
import com.picavi.jsonrpc.model.Request;
import com.picavi.jsonrpc.model.Response;

@Component
public class JsonRpcRequestHandler {

	@Autowired
	private RequestBroker requestBroker;

	public Response handleRequest(Request request) {
		isMethodValid(request);
		isParameterValid(request);

		Response response = null;

		try {
			response = invokeMethod(request);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException e) {
			throw new InternalException("Internal Error");
		}

		return response;
	}

	private void isMethodValid(Request request) {
		if (!requestBroker.getMap().containsKey(request.getMethod()))
			throw new RPCMethodNotFoundException("Method not found");
	}

	private void isParameterValid(Request request) {
		JsonNode params = request.getParams();
		if (!(!params.isNull() && (params.isObject() || params.isArray())))
			throw new InvalidMethodParameterException("Invalid method parameter(s)");
	}

	private Response invokeMethod(Request request) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
		ClassMetadata classMetadata = requestBroker.getMap().get(request.getMethod());
		Object classObj = Class.forName(classMetadata.getClassname()).newInstance();
		Method execMethod = classMetadata.getMethod();
		Response response = (Response) execMethod.invoke(classObj, request);
		return response;
	}

}
