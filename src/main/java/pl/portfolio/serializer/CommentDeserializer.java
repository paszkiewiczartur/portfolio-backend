package pl.portfolio.serializer;


import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import pl.portfolio.entities.Comment;
import pl.portfolio.repository.CommentsRepository;

public class CommentDeserializer extends StdDeserializer<Comment> { 
	 
	@Autowired
	private CommentsRepository commentsRepo;

    public CommentDeserializer() { 
        this(null); 
    } 
 
    public CommentDeserializer(Class<?> vc) { 
        super(vc); 
    }
 
    @Override
    public Comment deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Long id = node.get("id").numberValue().longValue();
        Comment comment = commentsRepo.findOne(id);
        LocalDateTime posted = LocalDateTime.parse(node.get("posted").asText());
        comment.setPosted(posted);
        String nickname = node.get("nickname").asText();
        comment.setNickname(nickname);
        String content = node.get("content").asText();
        comment.setContent(content);
        return comment;
    }
}