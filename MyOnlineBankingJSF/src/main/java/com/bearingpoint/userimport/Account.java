package com.bearingpoint.userimport;

/**
 * An account for a MyOnlineBanking user.
 * 
 * @author corian.paun
 *
 */
public class Account implements UniquelyIdentifiable {

	private String ID;
	private double amount;
	private String currency;

	public String getId() {
		return this.ID;
	}

	public void setId(String id) {
		this.ID = id;
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

	public String toString() {
		return this.getClass().getSimpleName() + "[id[" + this.ID + "],amount[" + this.amount + "],currency[" + this.currency + "]]";
	}

	public static void main(String[] args) {
		Account a = new Account();
		a.setId("id_a");
		a.setAmount(2543);
		a.setCurrency("curr_a");
		System.out.println(a);
	}
}
