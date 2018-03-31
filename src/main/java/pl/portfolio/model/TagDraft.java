package pl.portfolio.model;

import lombok.Data;

@Data
public class TagDraft {
	private Long id;
	private String path;
	private String name;
	private int amount;
}
