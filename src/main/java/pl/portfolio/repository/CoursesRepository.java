package pl.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Course;
import pl.portfolio.entities.Project;

@RepositoryRestResource(path = "courses", collectionResourceRel = "courses")
public interface CoursesRepository extends JpaRepository<Course, Long> {
	Course findByPath(@Param(value = "coursePath") String coursePath);
	
	@Query(value = "SELECT c FROM Course c WHERE c.searchString LIKE '%' || :text || '%'")
	List<Course> search(@Param(value = "text")String text);


}