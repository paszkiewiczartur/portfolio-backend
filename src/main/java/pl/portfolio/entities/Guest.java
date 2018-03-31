package pl.portfolio.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "guests")
@Data
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_guest")
	private Long id;
	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
    @OneToMany(mappedBy = "guest")
    private List<IpAddress> addresses = new ArrayList<>();

}
