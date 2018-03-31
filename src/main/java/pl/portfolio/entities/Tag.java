package pl.portfolio.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "tags")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Long id;
    @Column(nullable = false, unique=true)
    private String path;
    @Column(nullable = false)
	private String name;
    @Column(nullable = false)
	private String nameEn;
	private int amount = 0;
    @Column(nullable = false)
	private LocalDate added = LocalDate.now();
    @ManyToMany(mappedBy = "tags")
    private List<Book> books = new ArrayList<>();
    @ManyToMany(mappedBy = "tags")
    private List<Course> courses = new ArrayList<>();
    @ManyToMany(mappedBy = "tags")
    private List<Project> projects = new ArrayList<>();

    @PrePersist
    void onCreate() {
    	this.setAdded(LocalDate.now());
    }
}
