package de.derjonk.dev;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.derjonk.dev.model.FactorGroup;

@RepositoryRestResource(collectionResourceRel = "factorgroups", path = "factorgroups")
public interface FactorGroupRepository extends PagingAndSortingRepository<FactorGroup, Long> {

	List<FactorGroup> findByNameValue(@Param("name") String value);
}
