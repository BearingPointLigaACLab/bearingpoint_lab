package com.bearingpoint.onlinebanking;

import java.util.List;

/**
 * An abstract representation of Legal Entities that use MyOnlineBanking.
 * 
 * @author corian.paun
 *
 */
public interface LegalEntity extends UniquelyIdentifiable, Named{
	
	public Cluster getCluster();
	
	public void setCluster(Cluster cluster);
	
	public String getAddress();

	public void setAddress(String address);
	
	public List<Account> getAccounts();
	
	public void setAccounts(List<Account> account);
	
	public List<Transaction> getTransactions();
	
	public void setTransactions(List<Transaction> transactions);
	
	
	/**
	 * Returns the LegalEntity in String format: <LegalEntityType>[<LegalEntityID>:<LegalEntityName>,<LegalEntityChildren>]
	 * 
	 * @return
	 */
	public String getFormattedString();
}