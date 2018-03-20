package pl.portfolio.serializer;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import pl.portfolio.entities.Comment;


public class CommentSerializer extends StdSerializer<Comment> {
	private static final long serialVersionUID = 1L;

	public CommentSerializer() {
        this(null);
    }
   
    public CommentSerializer(Class<Comment> t) {
        super(t);
    }
 
    @Override
    public void serialize(
      Comment value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
  
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeObjectField("posted", value.getPosted());
        jgen.writeStringField("content", value.getContent());
        jgen.writeStringField("nickname", value.getNickname());
        if(value.getParent() != null)
        	jgen.writeNumberField("parent", value.getParent().getId());
        if(value.getProject() != null){
            jgen.writeStringField("path", "/projects/" + value.getProject().getPath());
            jgen.writeStringField("name", value.getProject().getName());        	
        } else if(value.getCourse() != null){
            jgen.writeStringField("path", "/courses/" + value.getCourse().getPath());
            jgen.writeStringField("name", value.getCourse().getName());        	
        } else if(value.getBook() != null){
            jgen.writeStringField("path", "/books/" + value.getBook().getPath());
            jgen.writeStringField("name", value.getBook().getName());        	
        }
        jgen.writeEndObject();
    }
}