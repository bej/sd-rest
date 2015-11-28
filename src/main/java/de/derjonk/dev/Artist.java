package de.derjonk.dev;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Album> albums;

	protected Artist() {

	}

	@JsonCreator
	public Artist(@JsonProperty("firstName") final String firstName, @JsonProperty("lastName") final String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	@JsonProperty("firstName")
	public String getFirstname() {
		return firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("firstName")
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void addAlbum(final Album... albums) {
		this.albums.addAll(Arrays.asList(albums));
	}

	@Override
	public String toString() {
		return String.format("Artist [id=%d, firstName=%s, lastName=%s]", id, firstName, lastName);
	}
}
