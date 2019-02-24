package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.admin.Admin;

public interface AdminDao {
	
	Integer selectCount();

	List<Admin> selectAllAdmin();

	Admin selectById(String id);
	
	List<String> selectAllUserName();

	Boolean insertAdmin(Admin admin);
	
	Admin selectNameById(String id);
}
