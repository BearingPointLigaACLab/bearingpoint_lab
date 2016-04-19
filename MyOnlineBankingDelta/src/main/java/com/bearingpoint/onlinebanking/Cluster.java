package com.bearingpoint.onlinebanking;

import java.util.List;

public class Cluster implements Named, UniquelyIdentifiable {

	private String id;
	private String name;
	private List<LegalEntity> legalEntities;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public List<LegalEntity> getLegalEntities() {
		return legalEntities;
	}

	public void setLegalEntities(List<LegalEntity> legalEntities) {
		this.legalEntities = legalEntities;
	}

	/**
	 * Returns the Cluster in String format: <ClusterId><ClusterName>[<LegalEntityChildren>]
	 */
	public String getFormattedString() {
		StringBuilder formattedString = new StringBuilder();
		formattedString.append("Cluster [ID - " + id + " Name - " + name + "]\n\tLegal entities: ");

		for (LegalEntity legEntity : legalEntities) {
			formattedString.append(legEntity.getFormattedString());
		}

		return formattedString.toString();
	}

}
