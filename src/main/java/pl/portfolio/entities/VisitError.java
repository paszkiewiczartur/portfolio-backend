package pl.portfolio.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import pl.portfolio.model.VisitErrorType;

@Entity
@Table(name = "visit_errors")
@Data
public class VisitError {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visit_error")
	private Long id;
	private Long guest;
	private Long ipAddress;
	private String ip;
	private VisitErrorType visitErrorType;
	private LocalDateTime createdAt = LocalDateTime.now();
}
