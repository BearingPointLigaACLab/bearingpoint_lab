package com.bearingpoint.admin;

public class Om 
{
	private String ID, name, clusterId, clusterName;
	public Om(String ID , String name, String clusterId , String clusterName)
	{
		this.ID = ID;
		this.name = name;
		this.clusterId = clusterId;
		this.clusterName = clusterName;
	}
	public String getID()
	{
		return this.ID;
	}
	public void setID(String ID)
	{
		this.ID = ID;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String Name)
	{
		this.name = Name;
	}
	public String getClusterId()
	{
		return this.clusterId;
	}
	public void setClusterId(String ID)
	{
		this.clusterId = ID;
	}
	public String getClusterName()
	{
		return this.clusterName;
	}
	public void setClusterName(String Name)
	{
		this.clusterName = Name;
	}
}
