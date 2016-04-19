package com.bearingpoint.onlinebanking;


import java.util.Date;

public class Transaction implements UniquelyIdentifiable{

	private String id;
	private String source;
	private String destination;
	private Date date;
	private double amount;
	
	public Transaction(String id, String source, String destination, Date date, double amount) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.amount = amount;
	}

	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Returns the Transaction in String format: <TransactionId><TransactionSource><TransactionDestination><TransactionDate><TransactionAmount>
	 */
	public String getFormattedString() {
		return "Transaction [ID - " + id + "; Source - " + source + "; Destination - " + destination + "; Date - " + date + "; Amount - " + amount + "]";
	}

}
