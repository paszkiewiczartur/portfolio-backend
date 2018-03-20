package pl.portfolio.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.portfolio.entities.Book;
import pl.portfolio.entities.Comment;
import pl.portfolio.entities.Course;
import pl.portfolio.entities.Project;
import pl.portfolio.model.SearchDraft;
import pl.portfolio.repository.BooksRepository;
import pl.portfolio.repository.CommentsRepository;
import pl.portfolio.repository.CoursesRepository;
import pl.portfolio.repository.ProjectsRepository;
import pl.portfolio.service.HtmlReplaceService;

@Controller
public class SearchController {
	@Autowired
	private ProjectsRepository projectsRepo;

	@Autowired
	private CoursesRepository coursesRepo;
	
	@Autowired
	private BooksRepository booksRepo;
	
	@Autowired
	private CommentsRepository commentsRepo;
	
	@Autowired
	private HtmlReplaceService htmlReplaceService;

	@RequestMapping(value = "/api/search/{text}", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<SearchDraft> search(@PathVariable String text){
		List<SearchDraft> result = new ArrayList<>();
		System.out.println("Seeking text---" + text + "---");
		text = text.trim();
		if(text.length() == 0 )
			return result;
		result.addAll(addProjects(text));
		result.addAll(addCourses(text));
		result.addAll(addBooks(text));
		result.addAll(addComments(text));
		Collections.shuffle(result);
		return result;
	}
	
	private List<SearchDraft> addProjects(String text){
		List<SearchDraft> result = new ArrayList<>();
		List<Project> projects = projectsRepo.search(text);
		for(Project project: projects){
			result.add(new SearchDraft("Project: " + project.getName(),
									"/projects/" + project.getPath(), 
									htmlReplaceService.abbreviate(project.getSearchString(), text)));
		}		
		return result;
	}

	private List<SearchDraft> addCourses(String text){
		List<SearchDraft> result = new ArrayList<>();
		for(Course course: coursesRepo.search(text)){
			result.add(new SearchDraft("Course: " + course.getName(),
									"/courses/" + course.getPath(), 
									htmlReplaceService.abbreviate(course.getSearchString(), text)));
		}		
		return result;
	}
	
	private List<SearchDraft> addBooks(String text){
		List<SearchDraft> result = new ArrayList<>();
		for(Book book: booksRepo.search(text)){
			result.add(new SearchDraft("Book: " + book.getName(),
									"/books/" + book.getPath(), 
									htmlReplaceService.abbreviate(book.getSearchString(), text)));
		}		
		return result;
	}

	private List<SearchDraft> addComments(String text){
		List<SearchDraft> result = new ArrayList<>();
		for(Comment comment: commentsRepo.search(text)){
			String entityName = "";
			if(comment.getProject() != null){
				entityName = comment.getProject().getName();
			} else if(comment.getCourse() != null){
				entityName = comment.getCourse().getName();
			} else if(comment.getBook() != null){
				entityName = comment.getBook().getName();
			}
			result.add(new SearchDraft("Comment to: "+ entityName,
									"/comments/" + comment.getId(), 
									htmlReplaceService.abbreviate(comment.getContent(), text)));
		}		
		return result;
	}
	
}
