package com.eilikce.osm.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.transformable.Admin;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.dao.AdminDao;
import com.eilikce.osm.entity.admin.AdminPo;


@Service
public class AdminServiceImpl implements AdminService{

	private static Logger logger = Logger.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao dao;
	
	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> adminBoList = new ArrayList<Admin>();
		List<AdminPo> adminList = dao.selectAllAdmin();
		adminBoList = BoTransHandler.entityListToBoList(Admin.class, adminList);
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
		
		AdminPo admin = new AdminPo(user_name, password, permissions);
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
        logger.error("用户"+name+"登陆成功");
    }

}
