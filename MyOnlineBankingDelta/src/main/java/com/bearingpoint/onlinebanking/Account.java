package com.bearingpoint.onlinebanking;


public class Account implements UniquelyIdentifiable{

	private double amount;
	private String currency;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

}
