package pl.portfolio.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import pl.portfolio.entities.Entrance;
import pl.portfolio.entities.Message;

@Data
public class MessageDTO {
    private String email;
    private String credentials;
    private String content;
    private LocalDateTime created = LocalDateTime.now();
    private Long entrance;
}
