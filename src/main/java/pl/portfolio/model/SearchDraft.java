package pl.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDraft {
	private String name;
	private String path;
	private String content;
}
