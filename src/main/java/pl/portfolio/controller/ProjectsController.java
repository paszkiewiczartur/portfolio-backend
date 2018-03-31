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

import pl.portfolio.entities.Project;
import pl.portfolio.model.Draft;
import pl.portfolio.repository.ProjectsRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class ProjectsController {
	@Autowired
	private ProjectsRepository projectsRepo;
	
	@RequestMapping(value = "/api/getProjects", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<Draft> returnProjects(){
		List<Project> projects = projectsRepo.findAll();
		List<Draft> drafts = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		Draft draft = null;
		for(Project project: projects){
			draft = modelMapper.map(project, Draft.class);
			draft.setImage(project.getImagePath());
			drafts.add(draft);
		}
		return drafts;
	}

	@RequestMapping(value = "/api/setProjectsOrder", method = RequestMethod.POST, consumes = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public void setProjectsOrder(@RequestBody List<Draft> drafts){
		for(Draft draft: drafts){
			Project project = projectsRepo.findOne(draft.getId());
			project.setSequence(draft.getSequence());
			projectsRepo.saveAndFlush(project);
		}
	}

	
}
