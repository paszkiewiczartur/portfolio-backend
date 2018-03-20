package pl.portfolio.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CommentDTO {
    private LocalDateTime posted = LocalDateTime.now();
	@NotNull
    private String content;
	@NotNull
    private String nickname;
    private String email;
    private Site site;
    private Long entity;
    private Long parent;
    private Long entrance;

}
