package com.eilikce.osm.service.admin;

import java.util.List;

import com.eilikce.osm.bo.admin.AdminBo;

public interface AdminService {
	
	//获取全部管理员信息
	List<AdminBo> getAllAdmin();
	
	//获取全部管理员数量
	Integer getCount();
	
	//添加新的管理员
	String addAdmin(String user_name, String password, String permissions);
}
