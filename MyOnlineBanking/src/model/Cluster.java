package model;

import java.util.List;

public class Cluster implements Named, UniquelyIdentifiable{

	private List<LegalEntity> legalEntities;
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Returns the Cluster in String format: <ClusterName>[<LegalEntityChildren>]
	 * 
	 * @return
	 */
	public String getFormattedString(){
		// TODO IMPLEMENT
		return null;
	}
}
