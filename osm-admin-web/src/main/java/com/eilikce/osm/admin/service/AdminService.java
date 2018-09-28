package com.eilikce.osm.admin.service;

import java.util.List;

import com.eilikce.osm.core.bo.transformable.Admin;
import org.apache.shiro.subject.Subject;

public interface AdminService {
	
	//获取全部管理员信息
	List<Admin> getAllAdmin();
	
	//获取全部管理员数量
	Integer getCount();
	
	//添加新的管理员
	String addAdmin(String user_name, String password, String permissions);

	void login(Subject subject, String name, String password);
}
