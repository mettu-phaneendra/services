package com.itag.api.server.v1.user.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

import com.itag.api.server.v1.user.model.Registration;
import com.itag.api.server.v1.user.model.RegistrationProvider;

@Service
public class RegisterationServiceProviderImpl implements
		RegisterationServiceProvider {

	public RegisterationServiceProviderImpl() {

	}

	@Override
	public RegistrationProvider register(Registration user,
			Locale locale) {
		RegistrationProvider register = new RegistrationProvider();
		register.setTestingService("testingService");
		return register;
	}
}
