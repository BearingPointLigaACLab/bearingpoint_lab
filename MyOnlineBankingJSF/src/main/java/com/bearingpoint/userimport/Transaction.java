package com.bearingpoint.userimport;

import java.util.Date;

/**
 * A transaction of a MyOnlineBanking user.
 * 
 * @author corian.paun
 *
 */
public class Transaction implements UniquelyIdentifiable {

	private String ID;
	private String source;
	private String destination;
	private Date date;
	private double amount;

	public String getId() {
		return this.ID;
	}

	public void setId(String id) {
		this.ID = id;
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

	public String toString() {
		return this.getClass().getSimpleName() + "[id[" + this.ID + "],source[" + this.source + "],destination=[" + this.destination + "],date["
				+ (date == null ? null : this.date.toString()) + "],amount[" + this.amount + "]]";
	}

	public static void main(String[] args) {
		Transaction t = new Transaction();
		t.setAmount(123);
		t.setDate(new Date());
		t.setDestination("dest_t");
		t.setSource("src_t");
		t.setId("id_t");

		System.out.println(t);
	}
}