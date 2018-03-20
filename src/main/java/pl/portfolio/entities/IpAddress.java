package pl.portfolio.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import pl.portfolio.model.VisitErrorType;

@Entity
@Table(name = "ip_address")
@Data
public class IpAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ip_address")
	private Long id;
	private String appLanguage;
	private String browserLanguage;
	private String browser;
	private String browserVersion;
	@Column(nullable = false)
	private String ip;
	private String city;
	private String region;
	private String country_name;
	private String continent_code;
	private String postal;
	private Float latitude;
	private Float longitude;
	private String timezone;
	private String languages;
	private String org;
	private LocalDateTime createdAt = LocalDateTime.now();
	@Enumerated(EnumType.ORDINAL)
	private VisitErrorType error;
	@ManyToOne
	@JoinColumn(name = "guest_id", nullable = false)
	private Guest guest;
	@OneToMany(mappedBy = "ip_address")
	List<Entrance> entrances = new ArrayList<>();
	
}
