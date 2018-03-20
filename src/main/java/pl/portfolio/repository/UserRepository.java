package pl.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.portfolio.entities.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(@Param(value = "username") String username);
}