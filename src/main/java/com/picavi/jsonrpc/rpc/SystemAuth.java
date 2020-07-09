package com.picavi.jsonrpc.rpc;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.picavi.jsonrpc.model.Credentials;
import com.picavi.jsonrpc.model.Request;
import com.picavi.jsonrpc.model.SuccessResponse;

@Service
public class SystemAuth {

	public SuccessResponse login(Request request) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode credentialRequest = request.getParams();
		Credentials credentials;
		credentials = mapper.treeToValue(credentialRequest, Credentials.class);
		return new SuccessResponse(request.getId(), credentials);
	}

}
