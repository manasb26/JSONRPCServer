package com.picavi.jsonrpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.picavi.jsonrpc.handler.JsonRpcRequestHandler;
import com.picavi.jsonrpc.model.Request;
import com.picavi.jsonrpc.model.Response;
import com.picavi.jsonrpc.validator.JsonRpcRequestValidator;

@Controller
@RequestMapping("/")
public class JsonRpcController {

	@Autowired
	private JsonRpcRequestHandler requestHandler;
	
	@Autowired
	private JsonRpcRequestValidator requestValidator;

	@PostMapping
	public ResponseEntity<Response> handleRequest(@RequestBody Request request) {
		requestValidator.validateRequest(request);
		Response response = requestHandler.handleRequest(request);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
