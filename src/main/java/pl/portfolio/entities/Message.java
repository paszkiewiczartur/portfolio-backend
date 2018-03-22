package pl.portfolio.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Long id;
    private String email;
    private String credentials;
    @Column(nullable = false, length = 9000)
    private String content;
    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "entrance_id", nullable = false)
    private Entrance entrance;
}
