package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.admin.AccountPo;

@Repository
public class AccountDaoImpl implements AccountDao {

	private static final String NAMESPACE = AccountDaoImpl.class.getPackage().getName() + "." + AccountDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer selectCount() {
		Integer count = (Integer)sqlSessionTemplate.selectOne(NAMESPACE + "selectCount");
		return count;
	}

	@Override
	public List<AccountPo> selectAllAccount() {
		List<AccountPo> accountList = new ArrayList<AccountPo>();
		accountList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllAccount");
		return accountList;
	}

	@Override
	public int insertAccount(AccountPo account) {
		int count = sqlSessionTemplate.insert(NAMESPACE+ "insertAccount", account);
		return count;
	}

	@Override
	public int insertAccountList(List<AccountPo> accountList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
