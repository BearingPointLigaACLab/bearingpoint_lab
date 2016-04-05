package main.java.com.bearingpoint.onlinebanking;
public abstract class AbstractClusterFactory {

	/**
	 * Reads clusters from the specified source.
	 * 
	 * @param source
	 * @return
	 */
	public abstract Cluster read(Object source);
}
