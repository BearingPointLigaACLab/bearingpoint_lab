/**
 * 
 */
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
@Table(name="app_user")
public class AppUser {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="admin")
	private String admin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin + "]";
	}
	
	public boolean isAdmin() {
		return admin != null && (admin.equalsIgnoreCase("Y") || admin.equals("1"));
	}
	
}
