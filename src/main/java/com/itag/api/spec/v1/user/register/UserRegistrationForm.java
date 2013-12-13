package com.itag.api.spec.v1.user.register;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserRegistration", propOrder = {
		"email",
		"passowrd-first",
		"passowrd-verify",
		"nick-name"
})

public class UserRegistrationForm {
	@XmlElement(name = "email")
	protected String email;
	
	@XmlElement(name = "password-first")
	protected String passwordFirst;
	
	@XmlElement(name = "password-verify")
	protected String passwordVerify;
	
	@XmlElement(name = "nick-name")
	protected String nickName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordFirst() {
		return passwordFirst;
	}

	public void setPasswordFirst(String passwordFirst) {
		this.passwordFirst = passwordFirst;
	}

	public String getPasswordVerify() {
		return passwordVerify;
	}

	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
