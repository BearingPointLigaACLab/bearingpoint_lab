package com.bearingpoint.onlinebanking;


public class Account implements UniquelyIdentifiable {
	
	private String id;
	private double amount;
	private String currency;

	public Account(String id, double amount, String currency) {
		this.id = id;
		this.amount = amount;
		this.currency = currency;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
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
	
	/**
	 * Returns the Account in String format: <AccountId><AccountAmount><AccountCurrency>
	 */
	public String getFormattedString() {
		return "Account [ID - " + id + "; Amount - " + amount + "; Currency - " + currency + "]";
	}
	
}
