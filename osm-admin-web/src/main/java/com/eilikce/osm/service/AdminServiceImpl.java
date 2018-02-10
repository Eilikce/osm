package com.eilikce.osm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.admin.bo.BoTransHandler;
import com.eilikce.osm.admin.bo.admin.AdminBo;
import com.eilikce.osm.dao.AdminDao;
import com.eilikce.osm.entity.admin.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	private static Logger logger = Logger.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao dao;
	
	@Override
	public List<AdminBo> getAllAdmin() {
		List<AdminBo> adminBoList = new ArrayList<AdminBo>();
		List<Admin> adminList = dao.selectAllAdmin();
		adminBoList = BoTransHandler.entityListToBoList(AdminBo.class, adminList);
		return adminBoList;
	}

	@Override
	public Integer getCount() {
		int count = dao.selectCount();
		return count;
	}

	@Override
	public String addAdmin(String user_name, String password, String permissions){
		String result = "";
		
		// 不允许重名用户
		List<String> userNameList = new ArrayList<String>();
		userNameList = dao.selectAllUserName();
		for (String un : userNameList) {
			if (un.equals(user_name)) {
				// 用户重复
				logger.info("新用户插入失败。用户名：" + user_name + "重复");
				result =  "repeat";
				
				return result;
			}
		}
		
		Admin admin = new Admin(user_name, password, permissions);
		boolean flag = dao.insertAdmin(admin);
		if(flag){
			result = "sucess" ;
		}else{
			result = "failed"	;
		}
		
		return result;
	}
	
}
