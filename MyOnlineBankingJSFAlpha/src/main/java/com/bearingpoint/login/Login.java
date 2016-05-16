package com.bearingpoint.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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
	public String verify()
	{
		if(user.equals("admin") && password.equals("admin"))
		{
			user=null;
			password=null;
			message = null;
			return "AdminPage";
		}
		else if(user.equals("andrei.mihut95") && password.equals("123456"))
		{
			user=null;
			password=null;
			message=null;
			return "HomePage";
		}
		else
		{
			this.message = "Invalid email and/or password. Please try again.";
			user = null;
			password = null;
			return "Login1";
		}
	}
	
	
}