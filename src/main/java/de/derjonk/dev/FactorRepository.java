package de.derjonk.dev;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.derjonk.dev.model.Factor;

@RepositoryRestResource(collectionResourceRel = "factors", path = "factors")
public interface FactorRepository extends PagingAndSortingRepository<Factor, Long> {

	// List<Factor> findByLastName(@Param("name") String lastName);
	// @Query("SELECT f FROM factor f WHERE f.name = :name")
	// List<Factor> findByGroup(@Param("name") String name);
}
