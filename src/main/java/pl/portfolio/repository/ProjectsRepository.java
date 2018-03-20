package pl.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Project;

@RepositoryRestResource(path = "projects", collectionResourceRel = "projects")
public interface ProjectsRepository extends JpaRepository<Project, Long> {
	Project findByPath(@Param(value = "projectPath") String projectPath);

	@Query(value = "SELECT p FROM Project p WHERE p.searchString LIKE '%' || :text || '%'")
	List<Project> search(@Param(value = "text") String text);
}