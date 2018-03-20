package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.SiteContent;

@RepositoryRestResource(path = "siteContent", collectionResourceRel = "siteContent")
public interface SiteContentRepository extends JpaRepository<SiteContent, Long> {
	SiteContent findByPath(@Param(value = "siteContentPath") String siteContentPath);
}