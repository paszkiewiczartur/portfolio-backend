package pl.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.portfolio.entities.Link;
import pl.portfolio.model.Site;
import pl.portfolio.repository.LinksRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class LinksController {
	@Autowired
	private LinksRepository linksRepo;
	
	@RequestMapping(value = "/api/getLinks", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<Link> returnComments(
			@RequestParam(value = "site", required = true) Site site,
			@RequestParam(value = "entity", required = true) Long entity){
		List<Link> links = linksRepo.findBySiteAndEntity(site, entity);
		return links;
	}

}
