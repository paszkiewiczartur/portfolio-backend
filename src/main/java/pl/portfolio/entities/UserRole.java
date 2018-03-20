package pl.portfolio.entities;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
 
@Entity
@Data
public class UserRole {
    @Id
    @GeneratedValue
    private Long id;
    private String role;
    private String description;
   
}