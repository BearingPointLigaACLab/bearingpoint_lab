package com.bearingpoint.login;

import javax.faces.bean.*;
@ManagedBean(name = "login" , eager = true)
@RequestScoped
public class Login 
{
	@ManagedProperty(value="#{user}")
	private String user;
	@ManagedProperty(value="#{password}")
	private String password;
	@ManagedProperty(value="#{message}")
	private String message;
	
	public String getUser() 
	{
		return user;
	}
   
	public void setUser(String user)
	{
		this.user = user;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

	public String changePage()
	{
		String nextPage = "Login";
		message=null;
		
		if (isValidUser())
		{
			if (isAdminUser())
			{
				nextPage = "AdminPage";
			} else
			{
				nextPage = "HomePage";
			}
			message = null;
		} else
		{
			this.message = "Invalid username and/or password. Please try again.";
		}
		password = null;
		return nextPage;
	}
	private boolean isValidUser()
	{
		boolean isValid = false;
		if(user.equals("admin") && password.equals("admin") || user.equals("andrei.mihut95") && password.equals("123456"))
		{
			isValid = true;
		}
		return isValid;
	}
	private boolean isAdminUser()
	{
		boolean isAdminUser = false;
		if (user.equals("admin"))
		{
			isAdminUser = true;
		}
		return isAdminUser;
	}
	
}