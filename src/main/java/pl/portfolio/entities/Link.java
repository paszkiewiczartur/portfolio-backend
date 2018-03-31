package pl.portfolio.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "link", orphanRemoval=true)
    private List<LinkEntrance> linkEntrances = new ArrayList<>();
    

}
