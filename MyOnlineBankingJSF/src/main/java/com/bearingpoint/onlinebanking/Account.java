package com.bearingpoint.onlinebanking;

public class Account implements UniquelyIdentifiable{

	private String ID;
	private double amount;
	private String currency;
	public String getId() 
	{
		return this.ID;
	}
	public void setId(String id) 
	{
		this.ID = id;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public String getCurrency() 
	{
		return currency;
	}

	public void setCurrency(String currency) 
	{
		this.currency = currency;
	}
	public String toString()
	{
		return "Account ID: " + this.ID + "\nAmount: " + this.amount + "\nCurrency: " + this.currency;
	}
}
