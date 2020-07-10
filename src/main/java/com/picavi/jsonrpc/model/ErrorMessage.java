package com.picavi.jsonrpc.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class ErrorMessage {
	
	@JsonProperty("code")
	private int code;

	@JsonProperty("message")
	private String message;

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("data")
	private JsonNode data;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(@JsonProperty("code") int code, @JsonProperty("message") String message,
			@JsonProperty("data") JsonNode data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public JsonNode getData() {
		return data;
	}

}
