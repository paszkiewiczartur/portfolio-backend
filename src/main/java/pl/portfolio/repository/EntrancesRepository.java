package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Entrance;

@RepositoryRestResource(path = "entrances", collectionResourceRel = "entrances")
public interface EntrancesRepository extends JpaRepository<Entrance, Long> {
}