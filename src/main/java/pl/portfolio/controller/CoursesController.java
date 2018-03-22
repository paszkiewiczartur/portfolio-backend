package pl.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.portfolio.entities.Course;
import pl.portfolio.model.Draft;
import pl.portfolio.repository.CoursesRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class CoursesController {
	@Autowired
	private CoursesRepository coursesRepo;

	@RequestMapping(value = "/api/getCourses", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<Draft> returnCourses(){
		List<Course> courses = coursesRepo.findAll();
		List<Draft> drafts = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		Draft draft = null;
		for(Course course: courses){
			draft = modelMapper.map(course, Draft.class);
			draft.setImage(course.getImagePath());
			drafts.add(draft);
		}
		return drafts;
	}
}
