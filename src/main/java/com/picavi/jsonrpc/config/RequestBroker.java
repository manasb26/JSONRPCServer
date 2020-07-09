package com.picavi.jsonrpc.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.picavi.jsonrpc.model.ClassMetadata;

@Component
public class RequestBroker {

	private Map<String, ClassMetadata> methodMap = new HashMap<String, ClassMetadata>();

	public void add(String methodName, ClassMetadata clazz) {
		if (methodName.isEmpty()) {
			throw new IllegalArgumentException("methodName");
		}

		if (clazz.getMethod() == null) {
			throw new IllegalArgumentException("method");
		}

		methodMap.put(methodName, clazz);
	}

	public Map<String, ClassMetadata> getMap() {
		return methodMap;
	}
}
