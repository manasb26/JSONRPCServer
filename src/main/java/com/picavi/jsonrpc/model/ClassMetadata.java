package com.picavi.jsonrpc.model;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

@Component
public class ClassMetadata {
	private Method method;

	private String classname;

	public ClassMetadata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassMetadata(Method method, String classname) {
		super();
		this.method = method;
		this.classname = classname;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
}
