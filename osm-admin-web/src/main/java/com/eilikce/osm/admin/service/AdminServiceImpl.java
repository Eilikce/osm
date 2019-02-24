package com.eilikce.osm.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.dao.AdminDao;
import com.eilikce.osm.entity.admin.Admin;


@Service
public class AdminServiceImpl implements AdminService{

	private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao dao;
	
	@Override
	public List<com.eilikce.osm.core.bo.transformable.Admin> getAllAdmin() {
		List<com.eilikce.osm.core.bo.transformable.Admin> adminBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.Admin>();
		List<Admin> adminList = dao.selectAllAdmin();
		adminBoList = BoTransHandler.entityListToBoList(com.eilikce.osm.core.bo.transformable.Admin.class, adminList);
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
				LOG.info("新用户插入失败。用户名：" + user_name + "重复");
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

    @Override
    public void login(Subject subject, String name, String password) {
        subject.login(new UsernamePasswordToken(name, password));
        LOG.error("用户"+name+"登陆成功");
    }

}
