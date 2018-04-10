package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.admin.AdminPo;

@Repository
public class AdminDaoImpl implements AdminDao{

	private static final String NAMESPACE = AdminDaoImpl.class.getPackage().getName() + "." + AdminDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer selectCount() {
		Integer count = (Integer)sqlSessionTemplate.selectOne(NAMESPACE + "selectCount");
		return count;
	}

	@Override
	public List<AdminPo> selectAllAdmin() {
		List<AdminPo> adminList = new ArrayList<AdminPo>();
		adminList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllAdmin");
		return adminList;
	}

	@Override
	public AdminPo selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> selectAllUserName() {
		List<String> userNameList = new ArrayList<String>();
		userNameList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllUserName");
		return userNameList;
	}
	
	@Override
	public Boolean insertAdmin(AdminPo admin) {
		int i = sqlSessionTemplate.insert(NAMESPACE + "insertAdmin", admin);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public AdminPo selectNameById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
