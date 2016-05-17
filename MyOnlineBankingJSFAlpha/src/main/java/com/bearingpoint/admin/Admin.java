package com.bearingpoint.admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.*;

@ManagedBean(name = "admin" , eager = true)
@RequestScoped
public class Admin 
{
	@ManagedProperty(value="#{users}")
	private ArrayList<Om> users = new ArrayList<Om>(Arrays.asList(
									new Om("id001", "Mihut", "cluster001", "myCluster"),
									new Om("id002", "Panfilii", "cluster001", "myCluster"),
									new Om("id003", "Stoian", "cluster001", "myCluster"),
									new Om("id004", "Balog", "cluster001", "myCluster"),
									new Om("id005", "Covaci", "cluster001", "myCluster"),
									new Om("id006", "Morariu", "cluster001", "myCluster"),
									new Om("id007", "Memetea", "cluster001", "myCluster"),
									new Om("id008", "Pirvu", "cluster001", "myCluster"),
									new Om("id009", "Marcu", "cluster001", "myCluster"),
									new Om("id010", "Mot", "cluster001", "myCluster")
									));
	@ManagedProperty(value="#{id}")
	private String ID;
	@ManagedProperty(value="#{name}")
	private String name;
	@ManagedProperty(value="#{clusterid}")
	private String clusterId;
	@ManagedProperty(value="#{clustername}")
	private String clusterName;
	public ArrayList<Om> getUsers()
	{
		return users;
	}
	public String getId() 
	{
		return this.ID;
	}
	public void setId(String id) 
	{
		this.ID = id;
	}
	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	public String getClusterId() 
	{
		return this.clusterId;
	}
	public void setClusterId(String cluster)
	{
		this.clusterId = cluster;
	}
	public String getClusterName()
	{
		return this.clusterName;
	}
	public void setClusterName(String cluster) 
	{
		this.clusterName = cluster;	
	}
}
