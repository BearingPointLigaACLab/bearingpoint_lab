package com.bearingpoint.onlinebanking;

import java.util.Date;

public class Transaction implements UniquelyIdentifiable{

	private String ID;
	private String source;
	private String destination;
	private Date date;
	private double amount;
	public String getId() 
	{
		return this.ID;
	}

	public void setId(String id)
	{
		this.ID = id;	
	}

	public String getSource()
	{
		return source;
	}
	public void setSource(String source)
	{
		this.source = source;
	}
	public String getDestination() 
	{
		return destination;
	}
	public void setDestination(String destination) 
	{
		this.destination = destination;
	}
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	public double getAmount() 
	{
		return amount;
	}
	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	public String toString()
	{
		return  "Transaction ID: " + this.ID + "\nSource: " + this.source + "\nDestination: " + this.destination
				+ "\nAmount: " + this.amount + "\nDate: " + this.date;
	}
}