package com.itag.api.server.v1.user.service;

import java.util.Locale;

import com.itag.api.server.v1.user.model.RegistrationProvider;
import com.itag.api.spec.v1.user.register.UserRegistrationForm;

public interface RegisterationServiceProvider {
	RegistrationProvider register(UserRegistrationForm user, Locale locale);

}
