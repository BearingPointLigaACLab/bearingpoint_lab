package com.bearingpoint.userimport;

import java.util.List;

/**
 * An abstract representation of legal entities that use MyOnlineBanking.
 * 
 * @author corian.paun
 *
 */
public interface LegalEntity extends UniquelyIdentifiable, Named {

	public String getAddress();

	public void setAddress(String address);

	public List<Account> getAccounts();

	public void setAccounts(List<Account> account);

	public List<Transaction> getTransactions();

	public void setTransactions(List<Transaction> transactions);

}