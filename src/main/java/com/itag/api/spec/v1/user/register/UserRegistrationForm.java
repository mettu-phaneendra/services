package com.itag.api.spec.v1.user.register;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user_registration")
public class UserRegistrationForm {
	@XmlElement(name = "email")
	protected String email;
	
	@XmlElement(name = "password_first")
	protected String passwordFirst;
	
	@XmlElement(name = "password_verify")
	protected String passwordVerify;
	
	@XmlElement(name = "nick_name")
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
