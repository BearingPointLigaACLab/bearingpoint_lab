package com.bearingpoint.gui;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.bearingpoint.dbutils.DBUtils;

@ManagedBean(name = "loginPage", eager = true)
@SessionScoped
public class LoginPage {
	private String user = null;
	private String password = null;
	private String message = null;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns the next page according to the login logic.
	 * 
	 * @return
	 */
	public String getNextPage() {
		String nextPage = "loginPage";
		if (DBUtils.isValidUser(user, password)) {
			if (DBUtils.isAdminUser(user, password)) {
				nextPage = "adminPage";
			} else {
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				Map<String, Object> sessionMap = externalContext.getSessionMap();
				sessionMap.put("user", user);
				nextPage = "homePage";
			}
			message = null;
		} else {
			this.message = "Invalid username and/or password. Please try again.";
		}
		return nextPage;
	}
}