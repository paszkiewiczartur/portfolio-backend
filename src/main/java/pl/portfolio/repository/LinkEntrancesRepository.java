package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.LinkEntrance;

@RepositoryRestResource(path = "linkEntrances", collectionResourceRel = "linkEntrances")
public interface LinkEntrancesRepository extends JpaRepository<LinkEntrance, Long> {
}