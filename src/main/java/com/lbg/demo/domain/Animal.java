package com.lbg.demo.domain;

public class Animal {

	String type;

	String colour;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Animal [type=" + type + ", colour=" + colour + "]";
	}

}
