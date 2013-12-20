package com.itag.api.server.v1.register.service;

import org.springframework.util.MultiValueMap;

import com.itag.api.server.v1.register.model.Registration;
import com.itag.api.server.v1.register.model.User;

public interface RegisterationServiceProvider {
	User register(Registration register, MultiValueMap<String, String> headers);

}
