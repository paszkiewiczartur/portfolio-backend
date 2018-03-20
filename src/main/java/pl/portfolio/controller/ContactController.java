package pl.portfolio.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.portfolio.entities.Entrance;
import pl.portfolio.entities.Message;
import pl.portfolio.model.MessageDTO;
import pl.portfolio.repository.EntrancesRepository;
import pl.portfolio.repository.MessagesRepository;

@Controller
public class ContactController {
	@Autowired
	private MessagesRepository messagesRepo;
	@Autowired
	private EntrancesRepository entrancesRepo;
	
	@RequestMapping(value = "/api/messages/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	public void saveComment(@Valid @RequestBody MessageDTO messageDTO){
		System.out.println("Received message");
		Entrance entrance = entrancesRepo.findOne(messageDTO.getEntrance());
		ModelMapper modelMapper = new ModelMapper();
		Message message = modelMapper.map(messageDTO, Message.class);
		message.setEntrance(entrance);
		messagesRepo.save(message);
	}
}
