package com.eilikce.osm.entity.admin;

import com.eilikce.osm.entity.CommonEntityPo;
import org.apache.ibatis.type.Alias;

@Alias("Admin")
public class AdminPo extends CommonEntityPo {

	private Integer id;
	private String userName;
	private String password;
	private String permissions;

	public AdminPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminPo(Integer id, String userName, String password, String permissions) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.permissions = permissions;
	}

	public AdminPo(String userName, String password, String permissions) {
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

}
