package model;
/**
 * An abstract representation of reporting objects (layers, modules, reports, etc.).
 * 
 * @author corian.paun
 *
 */
public interface LegalEntity {
	
	/**
	 * Returns the ID of the LegalEntity.
	 * 
	 * @return
	 */
	public String getID();
	
	/**
	 * Sets the ID of the LegalEntity.
	 * 
	 * @return
	 */
	public void setID();
	
	
	/**
	 * Returns the name of the LegalEntity.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Sets the name of the LegalEntity.
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * Returns the parent of the LegalEntity.
	 * 
	 * @return
	 */
	public String getAddress();

	/**
	 * Sets the parent of the LegalEntity.
	 * 
	 * @param parent
	 */
	public void setAddress(String address);

	/**
	 * Returns the LegalEntity in String format: <LegalEntityType>[<LegalEntityName>,<LegalEntityChildren>]
	 * 
	 * @return
	 */
	public String getFormattedString();
}