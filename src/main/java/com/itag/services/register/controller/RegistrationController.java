package com.itag.services.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/itag-services")
public class RegistrationController {  
    String message = "iTag server registration service !";  
  
    @RequestMapping(value="/register.do", method=RequestMethod.GET)  
    public ModelAndView showMessage() {  
        System.out.println("from controller");  
        return new ModelAndView("register", "message", message);  
    }  
}
