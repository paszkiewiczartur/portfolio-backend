package pl.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Comment;

@RepositoryRestResource(path = "comments", collectionResourceRel = "comments")
public interface CommentsRepository extends JpaRepository<Comment, Long> {
	@Query(value = "SELECT * FROM comments WHERE project_id = :project ", nativeQuery = true)
	List<Comment> findByProject(@Param(value = "project") Long project);

	@Query(value = "SELECT * FROM comments WHERE course_id = :course ", nativeQuery = true)
	List<Comment> findByCourse(@Param(value = "course") Long course);
	
	@Query(value = "SELECT * FROM comments WHERE book_id = :book ", nativeQuery = true)
	List<Comment> findByBook(@Param(value = "book") Long book);
	
	List<Comment> findByParent(Comment parent);

	@Query(value = "SELECT c FROM Comment c WHERE c.content LIKE '%' || :text || '%'")
	List<Comment> search(@Param(value = "text") String text);


}