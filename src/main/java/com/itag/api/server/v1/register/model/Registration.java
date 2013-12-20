package com.itag.api.server.v1.register.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "registration")
public class Registration extends BaseModel {
	protected String name;
	protected String email;
	protected String password;
	protected String verify;

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailId) {
		this.email = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameL) {
		this.name = nameL;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

}
