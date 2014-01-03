package com.itag.api.server.v1.register.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.itag.api.server.v1.register.biz.RegistrationBOF;
import com.itag.api.server.v1.register.biz.RegistrationBOFImpl;
import com.itag.api.server.v1.register.biz.RegistrationBo;
import com.itag.api.server.v1.register.model.Registration;
import com.itag.api.server.v1.register.model.User;

@Service
public class RegisterationServiceProviderImpl implements
		RegisterationServiceProvider {
	public RegistrationBOF registerBOF; 

	public RegisterationServiceProviderImpl() {
		registerBOF = new RegistrationBOFImpl();
	}

	@Override
	public User register(Registration register, MultiValueMap<String, String> headers) {
		registerBOF.register(registerBOF.mapModelToBo(register, RegistrationBo.class));
		return null;
	}
}
