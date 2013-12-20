package com.itag.api.server.v1.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itag.api.server.v1.register.model.Registration;
import com.itag.api.server.v1.register.model.User;
import com.itag.api.server.v1.register.service.RegisterationServiceProvider;

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

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {
			"application/xml", "application/json" })
	@ResponseBody
	public User register(@RequestBody Registration register,
			@RequestHeader MultiValueMap<String, String> headers) {
		//		return regServiceProvider.register(register, headers);
		User user = new User();
		user.setName(register.getName());
		user.setEmail(register.getEmail());
		return user; 
	}

}
