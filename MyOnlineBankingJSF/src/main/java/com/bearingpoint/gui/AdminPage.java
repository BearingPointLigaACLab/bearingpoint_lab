package com.bearingpoint.gui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;

import com.bearingpoint.dbutils.DBUtils;
import com.bearingpoint.userimport.Cluster;
import com.bearingpoint.userimport.XMLClusterFactory;

@ManagedBean(name = "adminPage", eager = true)
@SessionScoped
public class AdminPage {

	private User[] users = DBUtils.getDBUsers();
	private String message;

	private XMLClusterFactory factory = new XMLClusterFactory();

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Triggers the user import for the specified file.
	 */
	public void importUsers(FileUploadEvent event) {
		try {
			message = null;
			InputStream inputStream = new ByteArrayInputStream(event.getFile().getContents());
			Cluster cluster = factory.read(inputStream);
			message = "Users successfully imported from " + event.getFile().getFileName() + ".";
			DBUtils.addDBUsers(cluster);
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
		}
	}

	public static class User {
		String id;
		String name;
		String clusterId;
		String clusterName;

		public User(String id, String name, String clusterId, String clusterName) {
			this.id = id;
			this.name = name;
			this.clusterId = clusterId;
			this.clusterName = clusterName;
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

		public String getClusterId() {
			return clusterId;
		}

		public void setClusterId(String clusterId) {
			this.clusterId = clusterId;
		}

		public String getClusterName() {
			return clusterName;
		}

		public void setClusterName(String clusterName) {
			this.clusterName = clusterName;
		}

	}
}
