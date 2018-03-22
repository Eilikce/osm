package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.admin.Admin;

public class AdminBo extends EntityTransBo<Admin>{

	private Integer id;
	private String userName;
	private String password;
	private String permissions;

	public AdminBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminBo(String userName, String password, String permissions) {
		super();
		this.userName = userName;
		this.password = password;
		this.permissions = permissions;
	}

	public AdminBo(Admin admin) {
		super();
		this.id = admin.getId();
		this.userName = admin.getUserName();
		this.password = admin.getPassword();
		this.permissions = admin.getPermissions();
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
