package de.derjonk.dev.model;

import javax.persistence.Entity;

@Entity
public class Factor extends AbstractNamedModel {

	private String tag;

	protected Factor() {
		super();
	}

	public Factor(final Name name, final String tag) {
		super(name);
		this.tag = tag;
	}

	public String getRule() {
		return tag;
	}

}
