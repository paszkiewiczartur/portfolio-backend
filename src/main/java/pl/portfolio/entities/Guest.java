package pl.portfolio.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	//@JsonIgnore
	private LocalDateTime createdAt = LocalDateTime.now();
	/*identyfikacja
	 *1.client local storage check id
	 *2.client send ?id & ip
	 *3.server save
	 *4.server ?send id
	 *5.client save id in local storage
	 *6.client send id & action
	 *7.server save action
	 */
    @OneToMany(mappedBy = "guest")
    private List<IpAddress> addresses = new ArrayList<>();

}
