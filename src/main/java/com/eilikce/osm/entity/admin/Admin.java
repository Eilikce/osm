package com.eilikce.osm.entity.admin;

public class Admin {

	private Integer id;
	private String userName;
	private String password;
	private String permissions;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer id, String userName, String password, String permissions) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.permissions = permissions;
	}

	public Admin(String userName, String password, String permissions) {
		super();
		this.userName = userName;
		this.password = password;
		this.permissions = permissions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + ", permissions=" + permissions
				+ "]";
	}

}
