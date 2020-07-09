package com.picavi.jsonrpc.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ValueNode;

@Component
public class Response {

	private static final String VERSION = "2.0";

	@JsonProperty("jsonrpc")
	private String jsonrpc;

	@JsonProperty("id")
	private ValueNode id;

	public Response() {
		super();
	}

	public Response(ValueNode id) {
		this.id = id;
		jsonrpc = VERSION;
	}

	public Response(ValueNode id, String jsonrpc) {
		this.id = id;
		this.jsonrpc = jsonrpc;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}

	public ValueNode getId() {
		return id;
	}

}
