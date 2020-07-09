package com.picavi.jsonrpc.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Pickline {
	
	@JsonProperty("ident")
	private String ident;
	@JsonProperty("location")
	private String location;
	@JsonProperty("quantity")
	private Double quantity;
	@JsonProperty("item")
	private String item;
	@JsonProperty("unit")
	private String unit;

	public Pickline() {
		super();
	}

	public Pickline(String ident, String location, Double quantity, String item, String unit) {
		super();
		this.ident = ident;
		this.location = location;
		this.quantity = quantity;
		this.item = item;
		this.unit = unit;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
