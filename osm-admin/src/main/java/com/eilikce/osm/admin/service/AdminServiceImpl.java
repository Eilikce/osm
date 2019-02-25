package com.eilikce.osm.admin.service;

import com.eilikce.osm.core.bo.common.RequestData;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.dao.AdminDao;
import com.eilikce.osm.entity.admin.AdminPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AdminServiceImpl implements AdminService{

	private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao dao;
	
	@Override
	public List<com.eilikce.osm.core.bo.transformable.Admin> getAllAdmin() {
		List<com.eilikce.osm.core.bo.transformable.Admin> adminBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.Admin>();
		List<AdminPo> adminPoList = dao.selectAllAdmin();
		adminBoList = BoTransHandler.entityListToBoList(com.eilikce.osm.core.bo.transformable.Admin.class, adminPoList);
		return adminBoList;
	}

	@Override
	public Integer getCount() {
		int count = dao.selectCount();
		return count;
	}

	@Override
	public String addAdmin(RequestData requestData){

		String userName = (String) requestData.getData().get("userName");
		String password = (String) requestData.getData().get("password");
		String permissions = (String) requestData.getData().get("permissions");

		String result = "";
		
		// 不允许重名用户
		List<String> userNameList = new ArrayList<String>();
		userNameList = dao.selectAllUserName();
		for (String un : userNameList) {
			if (un.equals(userName)) {
				// 用户重复
				LOG.info("新用户插入失败。用户名：" + userName + "重复");
				result =  "repeat";
				
				return result;
			}
		}
		
		AdminPo adminPo = new AdminPo(userName, password, permissions);
		boolean flag = dao.insertAdmin(adminPo);
		if(flag){
			result = "sucess" ;
		}else{
			result = "failed"	;
		}
		
		return result;
	}

    @Override
    public void login(String name, String password) {
        LOG.error("用户"+name+"登陆成功");
    }

}
