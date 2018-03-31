package pl.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Book;

@RepositoryRestResource(path = "books", collectionResourceRel = "books")
public interface BooksRepository extends JpaRepository<Book, Long> {
	Book findByPath(@Param(value = "bookPath") String bookPath);
	
	@Query(value = "SELECT b FROM Book b WHERE b.searchString LIKE '%' || :text || '%'")
	List<Book> search(@Param(value = "text")String text);

}