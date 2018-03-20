package pl.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Link;
import pl.portfolio.model.Site;

@RepositoryRestResource(path = "links", collectionResourceRel = "links")
public interface LinksRepository extends JpaRepository<Link, Long> {
	List<Link> findBySiteAndEntity(@Param(value = "site") Site site, @Param(value = "entity") Long entity);
}