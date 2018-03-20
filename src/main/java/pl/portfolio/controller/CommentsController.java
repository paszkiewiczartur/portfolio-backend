package pl.portfolio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.portfolio.entities.Comment;
import pl.portfolio.model.CommentDTO;
import pl.portfolio.repository.CommentsRepository;
import pl.portfolio.service.CommentService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class CommentsController {
	@Autowired
	private CommentsRepository commentsRepo;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/api/comments/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveComment(@Valid @RequestBody CommentDTO commentDTO){
		System.out.println("commentDTO");
		System.out.println(commentDTO);
		Comment parent = null;
		if(commentDTO.getParent() != null)
			parent = commentsRepo.findOne(commentDTO.getParent());
		//Possible are only two levels of nesting
		if(parent != null && parent.getParent() != null){
			Comment grandparent = commentsRepo.findOne(parent.getParent().getId());
			if(grandparent != null && grandparent.getParent() != null){
				grandparent = commentsRepo.findOne(grandparent.getParent().getId());
				if(grandparent != null)
					return new ResponseEntity<>(new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
			}
		}
		Comment comment = commentService.createComment(commentDTO);
		if(parent != null)
			comment.setParent(parent);		
		commentsRepo.save(comment);
		return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/comments/delete/{commentId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public void deleteComment(@PathVariable("commentId") long commentId){
		Comment comment = commentsRepo.findOne(commentId);
		Comment parent = null;
		if(comment.getParent() != null)
			parent = commentsRepo.findOne(comment.getParent().getId());
		List<Comment> children = commentsRepo.findByParent(comment);
		for(int i=0; i<children.size(); i++){
			children.get(i).setParent(parent);
		}
		commentsRepo.save(children);
		commentsRepo.delete(comment);
	}

}
