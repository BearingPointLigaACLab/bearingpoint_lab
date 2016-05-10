package com.bearingpoint.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(eager = true)
@RequestScoped
public class HelloWorld {
	
	@ManagedProperty(value="#{message}")
	private String message;
	
	//this managed property will read value from request parameter pageId
	@ManagedProperty(value="#{param.pageId}")
	private String pageId;
   
	@ManagedProperty(value="#{inputText}")
	private String inputText;
	
	public String getMessage() {
		return "Hello World!";
	}
   
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getPageId(){
		return pageId;
	}
	
	public void setPageId(String pageId){
		this.pageId = pageId;
	}
	
	public String getInputText(){
		return inputText;
	}
	
	public void setInputText(String inputText){
		this.inputText = inputText;
	}
	
	public String getMessage_01(){
		return "This  is message 01!";
	}
	
	public String getMessage_02(){
		return "This is message 02!";
	}
	
	public String goToHelloWorld_02(){
		return "helloWorld_02";
	}
	
	public String goToHelloWorld_02_Conditional(){
		if ("go".equals(inputText))
		{
			return "helloWorld_02";
		}
		return null;
	}
	
	public String showPageById(){
		if ("2".equals(pageId))
		{
			return "helloWorld_02";
		}
		else
		{
			return "helloWorld_01";
		}
	}
	
	public void changeInputText(){
		this.inputText = inputText + "+";
	}
}