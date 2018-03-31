package pl.portfolio.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MessageDTO {
    private String email;
    private String credentials;
    private String content;
    private LocalDateTime created = LocalDateTime.now();
    private Long entrance;
}
