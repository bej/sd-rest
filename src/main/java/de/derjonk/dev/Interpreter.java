package de.derjonk.dev;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Interpreter {

	private final String name;

	@JsonCreator
	public Interpreter(@JsonProperty("name") final String name) {
		this.name = name;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}
}
