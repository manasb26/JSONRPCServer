package com.picavi.jsonrpc.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.picavi.jsonrpc.model.ClassMetadata;
import com.picavi.jsonrpc.model.Request;
import com.picavi.jsonrpc.rpc.SystemAuth;

@Configuration
public class JsonRpcConfig {

	@Autowired
	private RequestBroker requestBroker;

	@Bean
	public void registerMethod() {
		try {
			setLoginMethod();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setLoginMethod() throws NoSuchMethodException, SecurityException {
		Method loginMethod = SystemAuth.class.getMethod("login", Request.class);
		String className = SystemAuth.class.getName();
		ClassMetadata classMetadata = new ClassMetadata(loginMethod, className);
		requestBroker.add("system.login", classMetadata);
	}

}
