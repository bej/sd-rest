package de.derjonk.dev.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Reference {

	@Embedded
	private Name target;

	protected Reference() {
	}

	public Reference(final Name target) {
		this.target = target;
	}

	public Name getTarget() {
		return target;
	}

}
