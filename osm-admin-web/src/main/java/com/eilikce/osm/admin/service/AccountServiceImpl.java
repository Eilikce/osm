package com.eilikce.osm.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.transformable.AccountBo;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.dao.AccountDao;
import com.eilikce.osm.entity.admin.AccountPo;

@Service
public class AccountServiceImpl implements AccountService{

	private static Logger logger = Logger.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public int findCount() {
		int count = accountDao.selectCount();
		return count;
	}

	@Override
	public List<AccountBo> findAccountList() {
		List<AccountBo> accountBoList = new ArrayList<AccountBo>();
		List<AccountPo> accountList = accountDao.selectAllAccount();
		accountBoList = BoTransHandler.entityListToBoList(AccountBo.class, accountList);
		return accountBoList;
	}

	@Override
	public int addAccountBo(AccountBo accountBo) {
		AccountPo account = accountBo.transToEntity(AccountPo.class);
		int count = accountDao.insertAccount(account);
		logger.info("插入一条账单记录，账单号：" + account.getAccountId());
		return count;
	}

}
