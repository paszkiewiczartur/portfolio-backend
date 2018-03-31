package pl.portfolio.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private Long id;
    private Long sequence;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique=true)
    private String path;
    @Column(nullable = false, length = 5000)
    private String descriptionPl;
    @Column(nullable = false, length = 5000)
    private String descriptionEn;
    @Column(nullable = false)
    private String imagePath;
    @Column(nullable = false)
    private String githubLink;
    private String link;
    private String linkToDownload;
    @Column(nullable = false)
    private String lengthPl;
    @Column(nullable = false)
    private String lengthEn;
    @Column(nullable = false)
    private LocalDate posted = LocalDate.now();
    @Column(nullable = false)
    private LocalDate lastUpdate = LocalDate.now();
    @Column(nullable = false)
    private LocalDate workStarted;
    @Column(nullable = false)
    private boolean commentsAvailable;
    @Column(name = "search_string", length = 5000)
    private String searchString;
    @OneToMany(mappedBy = "project")
    private List<Comment> comments = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "project_tags",
            joinColumns = { @JoinColumn(name = "project_id", referencedColumnName = "id_project") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "id_tag") })
    private List<Tag> tags = new ArrayList<>();

    @PrePersist
    public void onCreate() {
    	this.setPosted(LocalDate.now());
    	this.setLastUpdate(LocalDate.now());
    	updateSearchString();
    }
    
    @PreUpdate
    public void onUpdate(){
    	updateSearchString();
    }
    
    private void updateSearchString() {
       this.searchString = StringUtils.join(Arrays.asList(
    		   name,
    		   replaceHtml(descriptionPl),
    		   replaceHtml(descriptionEn),
    		   githubLink,
    		   link,
    		   lengthPl,
    		   lengthEn),
               " ");
    }
    
    private String replaceHtml(String content){
    	return StringUtils.replaceAll(content, "<(.*?)>", " ");    	
    }

}
