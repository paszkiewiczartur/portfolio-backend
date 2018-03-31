package pl.portfolio.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ErrorPageController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
    	log.info("ERROR path");
    	return "index.html";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}
