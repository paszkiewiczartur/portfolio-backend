package pl.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VisitData {
	private Long ip_id;
	private Long guest_id;
	private Long entrance_id;
}
