package com.picavi.jsonrpc.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ValueNode;

@Component
public class ErrorResponse extends Response {

	@JsonProperty("error")
	private ErrorMessage error;

	public ErrorResponse(ValueNode id, String jsonrpc) {
		super(id, jsonrpc);
	}

	public ErrorResponse(ValueNode id) {
		super(id);
	}

	public ErrorResponse() {
	}

	public ErrorResponse(@JsonProperty("id") ValueNode id, @JsonProperty("error") ErrorMessage error) {
		super(id);
		this.error = error;
	}

	public ErrorResponse(ErrorMessage error) {
		super(NullNode.getInstance());
		this.error = error;
	}

	public ErrorMessage getError() {
		return error;
	}

}
