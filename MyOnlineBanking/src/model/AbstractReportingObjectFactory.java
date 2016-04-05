package model;
public abstract class AbstractReportingObjectFactory {

	/**
	 * Reads a layer from the specified source.
	 * 
	 * @param source
	 * @return
	 */
	public abstract Layer readLayer(Object source);

	/**
	 * Reads a module from the specified source.
	 * 
	 * @param source
	 * @return
	 */
	public abstract Module readModule(Object source);

	/**
	 * Reads a report from the specified source.
	 * 
	 * @param source
	 * @return
	 */
	public abstract User readReport(Object source);
}
