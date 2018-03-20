package pl.portfolio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import pl.portfolio.model.LinkType;
import pl.portfolio.model.Site;

@Entity
@Table(name = "links")
@Data
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_link")
    private Long id;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
    private Site site;
	@Column(name = "entity_id", nullable = false)
	private Long entity;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private LinkType linkType;
	//Book - visit A x 1
	//Course - visit A x 1
	//Project - visit, github, download(JavaFX) A x 3
	//Tags - visit A x 1 
	//Contact - visit 1 x 1 
	//About - visit, download(CV) 1 x 2
	// A = 5, Sum = 33

}
