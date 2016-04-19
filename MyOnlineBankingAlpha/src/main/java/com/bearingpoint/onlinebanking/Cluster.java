package com.bearingpoint.onlinebanking;

import java.util.*;

public class Cluster implements Named, UniquelyIdentifiable
{
	private String name;
	private String ID;
	private List<LegalEntity> legalEntities;
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
	public void setLegalEntities(List<LegalEntity> l)
	{
		this.legalEntities = l;
		for(LegalEntity om : l)
			om.setCluster(this);
	}
	public List<LegalEntity> getLegalEntities()
	{
		return this.legalEntities;
	}
	/**
	 * Returns the Cluster in String format: <ClusterName>[<LegalEntityChildren>]
	 * 
	 * @return
	 */
	public String getFormattedString()
	{
		int i;
		String s = "<" + this.getName() + ">";
		s += "[";
		if(legalEntities != null)
			for(i = 0 ; i < legalEntities.size() ; i++)
			{
				s += legalEntities.get(i).getName();
				if(i + 1 != legalEntities.size())
					s += ", ";
			}
		s += "]";
		return s;
	}
	public String toString()
	{
		return "[" + this.ID + ":" + this.name + "]";
	}
}
