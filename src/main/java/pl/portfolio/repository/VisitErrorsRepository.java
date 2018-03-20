package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.VisitError;

@RepositoryRestResource(path = "visitErrors", collectionResourceRel = "visitErrors")
public interface VisitErrorsRepository extends JpaRepository<VisitError, Long> {
}