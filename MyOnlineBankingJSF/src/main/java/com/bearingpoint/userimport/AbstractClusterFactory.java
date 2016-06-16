package com.bearingpoint.userimport;

/**
 * An abstract MyOnlineBanking cluster factory.
 * 
 * @author corian.paun
 *
 */
public abstract class AbstractClusterFactory {
	public abstract Cluster read(Object source) throws Exception;
}