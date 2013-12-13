package com.itag.services.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itag.api.server.v1.user.biz.RegistrationModelHelper;
import com.itag.api.server.v1.user.model.RegistrationProvider;
import com.itag.api.server.v1.user.service.RegisterationServiceProvider;
import com.itag.api.spec.v1.common.RequestOptions;
import com.itag.api.spec.v1.user.register.UserRegistrationForm;


@Controller
public class RegistrationController {  

    private RegisterationServiceProvider regServiceProvider;

	String message = "iTag server registration service !";  
    
    @RequestMapping(value="/register", method=RequestMethod.GET)  
    public ModelAndView showMessage() {  
        return new ModelAndView("register", "message", message);  
    }  
    
    @RequestMapping(value="/register-user", method=RequestMethod.POST)  
    public ModelMap register(            
    		final HttpServletRequest request,
            final HttpServletResponse response, 
            final UserRegistrationForm register,
            final ModelMap model,
            final RequestOptions requestOptions) {  
    	RegistrationProvider provider = regServiceProvider.register(register, requestOptions.getLocale());
    	
        return RegistrationModelHelper.initProviderToModel(response, model, provider, requestOptions);
    }
}
