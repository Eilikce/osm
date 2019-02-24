package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.admin.AdminPo;

public class Admin extends EntityTransBo<AdminPo>{

	private Integer id;
	private String userName;
	private String password;
	private String permissions;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String userName, String password, String permissions) {
		super();
		this.userName = userName;
		this.password = password;
		this.permissions = permissions;
	}

	public Admin(AdminPo adminPo) {
		super();
		this.id = adminPo.getId();
		this.userName = adminPo.getUserName();
		this.password = adminPo.getPassword();
		this.permissions = adminPo.getPermissions();
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
		return "AdminPo [id=" + id + ", userName=" + userName + ", password=" + password + ", permissions=" + permissions
				+ "]";
	}

}
