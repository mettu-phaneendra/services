package com.itag.services.register.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class RegistrationController {  
    String message = "iTag server registration service !";  
  
    @RequestMapping("/itag-services/register")  
    public ModelAndView showMessage() {  
        System.out.println("from controller");  
        return new ModelAndView("register", "message", message);  
    }  
}
