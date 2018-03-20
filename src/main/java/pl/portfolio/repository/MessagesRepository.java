package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.portfolio.entities.Message;

@RepositoryRestResource(path = "messages", collectionResourceRel = "messages")
public interface MessagesRepository extends JpaRepository<Message, Long> {
}