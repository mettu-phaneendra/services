package com.itag.api.server.v1.user.service;

import java.util.Locale;

import com.itag.api.server.v1.user.model.Registration;
import com.itag.api.server.v1.user.model.RegistrationProvider;

public interface RegisterationServiceProvider {
	RegistrationProvider register(Registration user, Locale locale);

}
