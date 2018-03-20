package pl.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.portfolio.entities.Book;
import pl.portfolio.entities.Comment;
import pl.portfolio.entities.Link;
import pl.portfolio.model.Draft;
import pl.portfolio.model.Site;
import pl.portfolio.repository.BooksRepository;
import pl.portfolio.repository.CommentsRepository;
import pl.portfolio.repository.CoursesRepository;
import pl.portfolio.repository.LinksRepository;
import pl.portfolio.repository.ProjectsRepository;
import pl.portfolio.repository.TagsRepository;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String home() {
    	//return "index";
    	return "index.html";
    }     
	@RequestMapping("/cookies")
    public String testing(@CookieValue(value = "foo", defaultValue = "failed") String foo, HttpServletResponse response) {
		System.out.println("Cookie: " + foo);
		Cookie cookie = new Cookie("bar", "try");
		response.addCookie(cookie);
		return "test";
    }     
}