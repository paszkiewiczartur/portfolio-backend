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
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique=true)
    private String path;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String descriptionPl;
    @Column(nullable = false)
    private String descriptionEn;
    private int rating;
    @Column(nullable = false)
    private String imagePath;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private int pages;
    @Column(nullable = false)
    //@JsonSerialize(using = LocalDateSerializer.class)
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate haveRead;
    @Column(nullable = false)
    //@JsonSerialize(using = LocalDateSerializer.class)
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate posted = LocalDate.now();
    @Column(nullable = false)
    //@JsonSerialize(using = LocalDateSerializer.class)
    //@JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate lastUpdate = LocalDate.now();
    @Column(nullable = false)
    private boolean commentsAvailable;
    @Column(name = "search_string", length = 5000)
    private String searchString;
    
    @OneToMany(mappedBy = "book")
    private List<Comment> comments = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "book_tags",
            joinColumns = { @JoinColumn(name = "book_id", referencedColumnName = "id_book") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "id_tag") })
    private List<Tag> tags = new ArrayList<>();
 
    @PrePersist
    public void onCreate(){
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
    		   author,
    		   replaceHtml(descriptionPl),
    		   replaceHtml(descriptionEn),
    		   link),
               " ");
    }
    
    private String replaceHtml(String content){
    	return StringUtils.replaceAll(content, "<(.*?)>", " ");    	
    }
    
    /*@PreUpdate
    public void onPersist() {
    	this.setLastUpdate(LocalDate.now());
    }*/
    
    /*public static class LocalDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(LocalDate arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException, JsonProcessingException {
            arg1.writeString(arg0.toString());
        }
    }

    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
            return LocalDate.parse(arg0.getText());
        }
    }*/
}
