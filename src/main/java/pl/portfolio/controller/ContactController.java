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

import lombok.extern.slf4j.Slf4j;
import pl.portfolio.email.ContactEmailSender;
import pl.portfolio.entities.Entrance;
import pl.portfolio.entities.Message;
import pl.portfolio.model.MessageDTO;
import pl.portfolio.repository.EntrancesRepository;
import pl.portfolio.repository.MessagesRepository;

@Controller
@Slf4j
public class ContactController {
	@Autowired
	private MessagesRepository messagesRepo;
	@Autowired
	private EntrancesRepository entrancesRepo;
	@Autowired
	private ContactEmailSender emailSender;
	
	@RequestMapping(value = "/api/messages/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	public void saveComment(@Valid @RequestBody MessageDTO messageDTO){
		log.info("Received message");
		Entrance entrance = entrancesRepo.findOne(messageDTO.getEntrance());
		ModelMapper modelMapper = new ModelMapper();
		Message message = modelMapper.map(messageDTO, Message.class);
		message.setEntrance(entrance);
		messagesRepo.saveAndFlush(message);
		if(messageDTO.getEmail() == null)
			messageDTO.setEmail("Brak");
		emailSender.sendHTMLEmail(messageDTO);
	}
}
