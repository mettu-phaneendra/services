package com.itag.services.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import com.itag.api.server.v1.user.biz.RegistrationModelHelper;
import com.itag.api.server.v1.user.model.RegistrationProvider;
import com.itag.api.server.v1.user.model.User;
import com.itag.api.server.v1.user.service.RegisterationServiceProvider;
import com.itag.api.spec.v1.common.RequestOptions;
import com.itag.api.spec.v1.user.register.Registration;


@Controller
public class RegistrationController {  
	
	@Autowired
    private RegisterationServiceProvider regServiceProvider;

	String message = "iTag server registration service !";  
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)  
    @ResponseBody
    public User getUserById(@PathVariable String id) {  
    	User user = new User();
    	user.setName("John Doe");
    	user.setEmail("jdoe@example.com");
        return user;  
    }  
    
    @RequestMapping(value="/register-user", method=RequestMethod.POST)  
    public ModelMap register(            
    		final HttpServletRequest request,
            final HttpServletResponse response, 
            final Registration register,
            final ModelMap model,
            final RequestOptions requestOptions) {
    	ServletWebRequest webRequest = new ServletWebRequest(request, response);
    	RegistrationProvider provider = regServiceProvider.register(register, requestOptions.getLocale());
    	
        return RegistrationModelHelper.initProviderToModel(response, model, provider, requestOptions);
    }
}
