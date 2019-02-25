package com.eilikce.osm.admin.service;

import com.eilikce.osm.core.bo.common.RequestData;
import com.eilikce.osm.core.bo.transformable.Admin;

import java.util.List;

public interface AdminService {
	
	//获取全部管理员信息
	List<Admin> getAllAdmin();
	
	//获取全部管理员数量
	Integer getCount();
	
	//添加新的管理员
	String addAdmin(RequestData requestData);

	void login(String name, String password);
}
