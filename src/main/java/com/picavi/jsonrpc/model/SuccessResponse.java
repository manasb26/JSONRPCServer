package com.picavi.jsonrpc.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ValueNode;

@Component
public class SuccessResponse extends Response {

	@JsonProperty("result")
	private Object result;

	public SuccessResponse() {
		super();
	}

	public SuccessResponse(ValueNode id, String jsonrpc) {
		super(id, jsonrpc);
	}

	public SuccessResponse(ValueNode id) {
		super(id);
	}

	public SuccessResponse(@JsonProperty("id") ValueNode id, @JsonProperty("result") Object result) {
		super(id);
		this.result = result;
	}

	public Object getResult() {
		return result;
	}
}
