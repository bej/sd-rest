package de.derjonk.dev;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Album extends ResourceSupport {

	private final String albumId;

	@JsonCreator
	public Album(@JsonProperty("albumId") final String albumId) {
		super();
		this.albumId = albumId;
	}

	@JsonProperty("albumId")
	public String getAlbumId() {
		return albumId;
	}

}
