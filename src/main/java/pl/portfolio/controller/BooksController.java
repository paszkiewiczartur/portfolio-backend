package pl.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.portfolio.entities.Book;
import pl.portfolio.model.Draft;
import pl.portfolio.repository.BooksRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class BooksController {
	@Autowired
	private BooksRepository booksRepo;
	
	@RequestMapping(value = "/api/getBooks", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<Draft> returnBooks(){
		List<Book> books = booksRepo.findAll();
		List<Draft> drafts = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		Draft draft = null;
		for(Book book: books){
			draft = modelMapper.map(book, Draft.class);
			draft.setImage(book.getImagePath());
			drafts.add(draft);
		}
		return drafts;
	}
	
	@RequestMapping(value = "/api/setBooksOrder", method = RequestMethod.POST, consumes = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public void setBooksOrder(@RequestBody List<Draft> drafts){
		for(Draft draft: drafts){
			Book book = booksRepo.findOne(draft.getId());
			book.setSequence(draft.getSequence());
			booksRepo.saveAndFlush(book);
		}
	}
}
