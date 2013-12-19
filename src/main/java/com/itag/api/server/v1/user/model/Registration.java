package com.itag.api.server.v1.user.model;

public class Registration {
	protected String name;
	protected String email;
	protected String passwordFirst;
	protected String passwordVerify;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
