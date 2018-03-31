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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import pl.portfolio.serializer.CommentDeserializer;
import pl.portfolio.serializer.CommentSerializer;

@Entity
@Table(name = "comments")
@Data
@JsonSerialize(using = CommentSerializer.class)
@JsonDeserialize(using = CommentDeserializer.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Long id;
    @Column(nullable = false)
    private LocalDateTime posted;
//    @Column(nullable = false, columnDefinition="text")
    @Column(nullable = false, length = 9000)
    private String content;
    @Column(nullable = false)
    private String nickname;
    @JsonIgnore
    private String email;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToMany
    @JoinTable(name = "entrance_comments",
    		joinColumns = { @JoinColumn(name = "comment_id", referencedColumnName = "id_comment") },
    		inverseJoinColumns = { @JoinColumn(name = "entrance_id", referencedColumnName = "id_entrance") })
    private List<Entrance> entrances = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "comment_parent_id")
    private Comment parent;
    

}
