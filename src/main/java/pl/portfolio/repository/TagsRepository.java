package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Tag;

@RepositoryRestResource(path = "tags", collectionResourceRel = "tags")
public interface TagsRepository extends JpaRepository<Tag, Long> {
	Tag findByPath(@Param(value = "tagPath") String tagPath);
}