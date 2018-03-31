package pl.portfolio.model;

import lombok.Data;

@Data
public class Draft {
	private Long id;
    private Long sequence;
    private String name;
    private String path;
    private String image;
}
