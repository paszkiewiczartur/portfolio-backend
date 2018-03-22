package pl.portfolio.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pl.portfolio.model.MessageDTO;
import pl.portfolio.service.EmailServiceImpl;

@Component
public class ContactEmailSender {
    @Autowired
	private EmailServiceImpl emailService;
    
    @Value("${contactEmailSubject}")
	private String emailSubject;
    @Value("${contactEmailAddress}")
	private String emailAddress;
	@Value("${contactEmailPattern}")
	private String contactEmailPattern;
	
	public void sendHTMLEmail(MessageDTO messageDTO){
		String emailContent = emailContent(messageDTO);
		emailService.sendHTMLMessage(emailAddress, emailSubject, emailContent);
	}

	public String emailContent(MessageDTO messageDTO){
		return String.format(contactEmailPattern, messageDTO.getCredentials(), messageDTO.getEmail(), messageDTO.getContent());
	}

}
