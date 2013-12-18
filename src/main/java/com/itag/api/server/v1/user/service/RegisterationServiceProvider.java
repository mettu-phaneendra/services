package com.itag.api.server.v1.user.service;

import java.util.Locale;

import com.itag.api.server.v1.user.model.RegistrationProvider;
import com.itag.api.spec.v1.user.register.Registration;

public interface RegisterationServiceProvider {
	RegistrationProvider register(Registration user, Locale locale);

}
