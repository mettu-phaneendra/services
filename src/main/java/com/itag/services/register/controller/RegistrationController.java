package com.itag.services.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {  
    String message = "iTag server registration service !";  
  
    @RequestMapping(value="/register", method=RequestMethod.GET)  
    public ModelAndView showMessage() {  
        return new ModelAndView("register", "message", message);  
    }  
    
    @RequestMapping(value="/register-user", method=RequestMethod.POST)  
    public ModelAndView showMessages() {  
        return new ModelAndView("register", "message", message);  
    }
}
