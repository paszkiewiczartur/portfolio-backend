package pl.portfolio.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import pl.portfolio.model.IpAddressDTO;
import pl.portfolio.model.VisitData;
import pl.portfolio.service.VisitService;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "Authorization")
@Controller
public class VisitController {
	@Autowired
	private VisitService saveGuestService;
	
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Principal login(Principal user) {
    	log.info("/login endpoint");
    	log.info(user.getName().toString());
    	System.out.println(user.getName().toString());
        return user;
    }
	
	@PostMapping("/api/guests/save")
    public @ResponseBody VisitData saveGuest(@Valid @RequestBody IpAddressDTO ipAddressDTO) {
		log.info(ipAddressDTO.toString());
		return saveGuestService.saveGuest(ipAddressDTO);
	}

}
