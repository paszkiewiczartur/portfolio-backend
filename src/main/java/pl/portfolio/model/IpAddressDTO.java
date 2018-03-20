package pl.portfolio.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class IpAddressDTO {
	/*private Long id;
	private Guest guest;
	private Entrance entrance;*/

	private Long id;
	private String appLanguage;
	private String browserLanguage;
	private String browser;
	private String browserVersion;
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
	@JsonIgnore
	private LocalDateTime createdAt = LocalDateTime.now();
	private VisitErrorType error;
	private Long guest_id;
	private Long entrance;
}
