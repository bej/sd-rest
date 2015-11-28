package de.derjonk.dev;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Song {

	private final String name;

	@JsonCreator
	public Song(@JsonProperty("name") final String name) {
		super();
		this.name = name;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

}
