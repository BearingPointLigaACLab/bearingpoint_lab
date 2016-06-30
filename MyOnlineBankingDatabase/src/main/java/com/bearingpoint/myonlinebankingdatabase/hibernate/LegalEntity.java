package com.bearingpoint.myonlinebankingdatabase.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cristian.gaidos
 *
 */
@Entity
@Table(name="legal_entity")
public class LegalEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column
	private String name;
	
	@Column(name="addres")
	private String address;
	
	@Column(name="appuserid")
	private String appUserID;
	
	@Column(name="appclusterid")
	private String appClusterID;

	public LegalEntity() {
		
	}

	public LegalEntity(String id, String name, String address, String appUserID, String appClusterID) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.appUserID = appUserID;
		this.appClusterID = appClusterID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAppUserID() {
		return appUserID;
	}

	public void setAppUserID(String appUserID) {
		this.appUserID = appUserID;
	}

	public String getAppClusterID() {
		return appClusterID;
	}

	public void setAppClusterID(String appClusterID) {
		this.appClusterID = appClusterID;
	}

	@Override
	public String toString() {
		return "LegalEntity [id=" + id + ", name=" + name + ", address=" + address + ", appUserID=" + appUserID
				+ ", appClusterID=" + appClusterID + "]";
	}
	
	
}
