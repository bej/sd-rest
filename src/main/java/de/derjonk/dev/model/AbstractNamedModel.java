package de.derjonk.dev.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class AbstractNamedModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Embedded
	private Name name;

	public AbstractNamedModel(final Name name) {
		this.name = name;
	}

	protected AbstractNamedModel() {
	}

	public Name getName() {
		return name;
	}
}
