package com.picavi.jsonrpc.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.picavi.jsonrpc.config.RequestBroker;
import com.picavi.jsonrpc.model.ClassMetadata;
import com.picavi.jsonrpc.model.Request;
import com.picavi.jsonrpc.model.Response;

@Component
public class JsonRpcRequestHandler {

	@Autowired
	private RequestBroker requestBroker;

	public Response handleRequest(Request request) {

		Response response = null;

		try {
			response = invokeMethod(request);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;

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
