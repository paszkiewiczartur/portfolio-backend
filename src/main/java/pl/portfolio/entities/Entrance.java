package pl.portfolio.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "entrances")
@Data
public class Entrance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrance")
    private Long id;
    @Column(nullable = false)
    private LocalDateTime visited = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "ip_address_id", nullable = false)
	private IpAddress ip_address;
    private String browser;
    private String browserVersion;
    @OneToMany(mappedBy = "entrance")
    private List<LinkEntrance> actions = new ArrayList<>();
    @ManyToMany(mappedBy = "entrances")
    private List<Comment> comments = new ArrayList<>();
}
