package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Guest;

@RepositoryRestResource(path = "guests", collectionResourceRel = "guests")
public interface GuestsRepository extends JpaRepository<Guest, Long> {
}