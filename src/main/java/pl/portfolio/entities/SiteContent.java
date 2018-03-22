package pl.portfolio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "site_content")
@Data
public class SiteContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_site_content")
	private Long id;
	@Column(nullable = false, unique=true)
	private String path;
	@Column(nullable = false, length = 10000)
	private String descriptionPl;
	@Column(nullable = false, length = 10000)
	private String descriptionEn;
}
