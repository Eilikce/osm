package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.admin.Account;

public interface AccountDao {
	
	/** 查询总条数 **/
	Integer selectCount();

	/** 查询全部账单 **/
	List<Account> selectAllAccount();
	
	/** 插入一条账单记录 **/
	int insertAccount(Account account);
	
	/** 插入多条账单记录 **/
	int insertAccountList(List<Account> accountList);
}
