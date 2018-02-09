package com.eilikce.osm.service.admin;

import java.util.List;

import com.eilikce.osm.bo.admin.AccountBo;

public interface AccountService {

	/** 查找账单总条数 **/
	int findCount();
	
	/** 查看全部账单 **/
	List<AccountBo> findAccountList();
	
	/** 新增一条账单 **/
	int addAccountBo(AccountBo accountBo);
	
	
	
}
