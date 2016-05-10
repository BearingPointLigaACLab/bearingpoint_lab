package com.bearingpoint.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean (eager = true)
public class LoginBean {

	@ManagedProperty(value="#{username}")
	private String username;
	
	@ManagedProperty(value="#{password}")
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		if("admin".equals(username) && "admin".equals(password))
		{
			return "helloWorld_01";
		}
		return null;
	}
}
