package pl.portfolio.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.portfolio.entities.Comment;
import pl.portfolio.entities.Entrance;
import pl.portfolio.model.CommentDTO;
import pl.portfolio.model.Site;
import pl.portfolio.repository.BooksRepository;
import pl.portfolio.repository.CoursesRepository;
import pl.portfolio.repository.EntrancesRepository;
import pl.portfolio.repository.ProjectsRepository;

@Service
public class CommentService {
	@Autowired
	private EntrancesRepository entrancesRepo;
	@Autowired
	private ProjectsRepository projectsRepo;
	@Autowired
	private CoursesRepository coursesRepo;
	@Autowired
	private BooksRepository booksRepo;
	
	public Comment createComment(CommentDTO commentDTO){
		ModelMapper modelMapper = new ModelMapper();
		Comment comment = modelMapper.map(commentDTO, Comment.class);

		Entrance entrance = entrancesRepo.findOne(commentDTO.getEntrance());
		comment.getEntrances().add(entrance);

		if(commentDTO.getSite().equals(Site.Project)){
			comment.setProject(projectsRepo.findOne(commentDTO.getEntity()));
		} else if (commentDTO.getSite().equals(Site.Course)){
			comment.setCourse(coursesRepo.findOne(commentDTO.getEntity()));			
		} else if (commentDTO.getSite().equals(Site.Book)){
			comment.setBook(booksRepo.findOne(commentDTO.getEntity()));
		}

		return comment;
	}
	

}
