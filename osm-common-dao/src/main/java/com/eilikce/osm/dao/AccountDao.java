package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.admin.AccountPo;

public interface AccountDao {
	
	/** 查询总条数 **/
	Integer selectCount();

	/** 查询全部账单 **/
	List<AccountPo> selectAllAccount();
	
	/** 插入一条账单记录 **/
	int insertAccount(AccountPo accountPo);
	
	/** 插入多条账单记录 **/
	int insertAccountList(List<AccountPo> accountPoList);
}
