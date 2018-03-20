package pl.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.portfolio.entities.Book;
import pl.portfolio.entities.Course;
import pl.portfolio.entities.Project;
import pl.portfolio.entities.Tag;
import pl.portfolio.model.Draft;
import pl.portfolio.model.Site;
import pl.portfolio.model.TagDTO;
import pl.portfolio.model.TagDraft;
import pl.portfolio.repository.BooksRepository;
import pl.portfolio.repository.CoursesRepository;
import pl.portfolio.repository.ProjectsRepository;
import pl.portfolio.repository.TagsRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class TagsController {
	@Autowired
	private TagsRepository tagsRepo;
	@Autowired
	private ProjectsRepository projectsRepo;
	@Autowired
	private CoursesRepository coursesRepo;
	@Autowired
	private BooksRepository booksRepo;
	
	@PostMapping("/api/tags/saveRelation")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEntity(@Valid @RequestBody TagDTO tagDTO) {
		Tag tag = tagsRepo.findOne(tagDTO.getTag());
		tag.setAmount(tag.getAmount() + 1);
		tagsRepo.save(tag);
		if (tagDTO.getSite() == Site.Project){
			Project project = projectsRepo.findOne(tagDTO.getEntity());
			project.getTags().add(tag);
			projectsRepo.save(project);
		} else if (tagDTO.getSite() == Site.Course){
			Course course = coursesRepo.findOne(tagDTO.getEntity());
			course.getTags().add(tag);
			coursesRepo.save(course);			
		} else if (tagDTO.getSite() == Site.Book){
			Book book = booksRepo.findOne(tagDTO.getEntity());
			book.getTags().add(tag);
			booksRepo.save(book);
		} else {
			System.out.println("Error! No site in /api/tags/saveRelation");
		}		
	}

	@PostMapping("/api/tags/deleteRelation")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEntity(@Valid @RequestBody TagDTO tagDTO) {
		Tag tag = tagsRepo.findOne(tagDTO.getTag());
		tag.setAmount(tag.getAmount() - 1);
		tagsRepo.save(tag);
		if (tagDTO.getSite() == Site.Project){
			Project project = projectsRepo.findOne(tagDTO.getEntity());
			project.getTags().remove(tag);
			projectsRepo.save(project);
		} else if (tagDTO.getSite() == Site.Course){
			Course course = coursesRepo.findOne(tagDTO.getEntity());
			course.getTags().remove(tag);
			coursesRepo.save(course);			
		} else if (tagDTO.getSite() == Site.Book){
			Book book = booksRepo.findOne(tagDTO.getEntity());
			book.getTags().remove(tag);
			booksRepo.save(book);
		} else {
			System.out.println("Error! No site in /api/tags/deleteRelation");
		}		
	}
	

	@RequestMapping(value = "/api/getTags", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<TagDraft> returnTags(){
		List<Tag> tags = tagsRepo.findAll();
		List<TagDraft> drafts = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		TagDraft draft = null;
		for(Tag tag: tags){
			draft = modelMapper.map(tag, TagDraft.class);
			drafts.add(draft);
		}
		return drafts;
	}
}