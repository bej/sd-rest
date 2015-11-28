package de.derjonk.dev.model;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

	private String value;

	protected Name() {
	}

	public Name(final String value) {
		this.value = value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
