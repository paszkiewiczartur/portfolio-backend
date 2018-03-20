package pl.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
			drafts.add(draft);
		}
		return drafts;
	}
}
