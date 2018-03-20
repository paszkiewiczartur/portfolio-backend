package pl.portfolio.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.portfolio.entities.Entrance;
import pl.portfolio.entities.Guest;
import pl.portfolio.entities.IpAddress;
import pl.portfolio.entities.VisitError;
import pl.portfolio.model.IpAddressDTO;
import pl.portfolio.model.VisitData;
import pl.portfolio.model.VisitErrorType;
import pl.portfolio.repository.EntrancesRepository;
import pl.portfolio.repository.GuestsRepository;
import pl.portfolio.repository.IpAddressRepository;
import pl.portfolio.repository.VisitErrorsRepository;
import pl.portfolio.service.VisitService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "Authorization")
@Controller
public class VisitController {
	@Autowired
	private VisitService saveGuestService;
	
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Principal login(Principal user) {
    	System.out.println("/login endpoint");
        return user;
    }
	
	@PostMapping("/api/guests/save")
    public @ResponseBody VisitData saveGuest(@Valid @RequestBody IpAddressDTO ipAddressDTO) {
		System.out.println(ipAddressDTO);
		return saveGuestService.saveGuest(ipAddressDTO);
	}

}
