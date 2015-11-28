package de.derjonk.dev;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	protected Album() {
	}

	@JsonCreator
	public Album(@JsonProperty("albumId") final String name) {
		super();
		this.name = name;
	}

	@JsonProperty("albumId")
	public String getAlbumId() {
		return name;
	}

}
