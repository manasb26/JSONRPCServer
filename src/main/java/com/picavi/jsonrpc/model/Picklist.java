package com.picavi.jsonrpc.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Picklist {

	@JsonProperty("ident")
	private String ident;

	@JsonProperty("lines")
	private List<Pickline> lines;

	public Picklist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Picklist(String ident) {
		super();
		this.ident = ident;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public List<Pickline> getLines() {
		return lines;
	}

	public void setLines(List<Pickline> lines) {
		this.lines = lines;
	}

}
