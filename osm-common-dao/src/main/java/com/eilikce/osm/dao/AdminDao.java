package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.admin.AdminPo;

public interface AdminDao {
	
	Integer selectCount();

	List<AdminPo> selectAllAdmin();

	AdminPo selectById(String id);
	
	List<String> selectAllUserName();

	Boolean insertAdmin(AdminPo admin);
	
	AdminPo selectNameById(String id);
}
