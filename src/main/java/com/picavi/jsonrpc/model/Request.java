package com.picavi.jsonrpc.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ValueNode;

@Component
public class Request {

	@JsonProperty("jsonrpc")
	private String jsonrpc;

	@JsonProperty("method")
	private String method;

	@JsonProperty("params")
	private JsonNode params;

	@JsonProperty("id")
	private ValueNode id;

	public Request() {
		super();
	}

	public Request(@JsonProperty("jsonrpc") String jsonrpc, @JsonProperty("method") String method,
			@JsonProperty("params") JsonNode params, @JsonProperty("id") ValueNode id) {
		this.jsonrpc = jsonrpc;
		this.method = method;
		this.id = id;
		this.params = params;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}

	public String getMethod() {
		return method;
	}

	public ValueNode getId() {
		return id;
	}

	public JsonNode getParams() {
		return params;
	}

}
