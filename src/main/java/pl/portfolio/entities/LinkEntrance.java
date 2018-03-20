package pl.portfolio.entities;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "link_entrances")
@Data
public class LinkEntrance {	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_link_entrance")
    private Long id;
    @Column(nullable = false)
    private LocalDateTime visited = LocalDateTime.now();
//    private LocalDateTime visited;
    @ManyToOne
    @JoinColumn(name = "entrance_id", nullable = false)
    private Entrance entrance;
    @ManyToOne
    @JoinColumn(name = "link_id", nullable = false)
    private Link link;
    
}
