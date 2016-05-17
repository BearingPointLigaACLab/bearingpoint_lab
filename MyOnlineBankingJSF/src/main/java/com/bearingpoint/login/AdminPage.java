package com.bearingpoint.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.bearingpoint.onlinebanking.Cluster;
import com.bearingpoint.onlinebanking.Individual;
import com.bearingpoint.onlinebanking.LegalEntity;

@ManagedBean(name = "adminPage" , eager = true)
@SessionScoped
public class AdminPage {

	private static User[] users;
	
	@ManagedProperty(value="#{importFile}")
	private  String importFile;
	
	public User[] getUsers(){
		return users;
	}
	
	public static void setUsers(User[] users){
		AdminPage.users = users;
	}
	
	public String getImportFile(){
		return importFile;
	}
	
	public void setImportFile(String importFile){
		this.importFile = importFile;
	}
	
	public void importUsers(){
		users = new User[] {
				new User("id1","Name 1","clusterId1","Cluster Name 1"),
				new User("id2","Name 2","clusterId2","Cluster Name 2")
		};
	}
	
	public static class User{
		@ManagedProperty(value="#{id}")
		String id;
		@ManagedProperty(value="#{name}")
		String name;
		@ManagedProperty(value="#{clusterId}")
		String clusterId;
		@ManagedProperty(value="#{clusterName}")
		String clusterName;
		
		public User(String id, String name, String clusterId, String clusterName)
		{
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
