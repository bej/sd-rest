package de.derjonk.dev.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class FactorGroup extends AbstractNamedModel {

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Reference> factorReferences;

	protected FactorGroup() {
	}

	public FactorGroup(final Name name) {
		super(name);
	}

	public void addFactorReference(final Reference ref) {
		this.factorReferences.add(ref);
	}

	public List<Reference> getFactorReferences() {
		return factorReferences;
	}

}
