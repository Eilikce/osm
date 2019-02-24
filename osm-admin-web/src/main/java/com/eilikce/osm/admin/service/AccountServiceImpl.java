package com.eilikce.osm.admin.service;

import java.util.ArrayList;
import java.util.List;

import com.eilikce.osm.dao.AccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.handler.BoTransHandler;

@Service
public class AccountServiceImpl implements AccountService{

	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public int findCount() {
		int count = accountDao.selectCount();
		return count;
	}

	@Override
	public List<com.eilikce.osm.core.bo.transformable.Account> findAccountList() {
		List<com.eilikce.osm.core.bo.transformable.Account> accountBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.Account>();
		List<com.eilikce.osm.entity.admin.Account> accountList = accountDao.selectAllAccount();
		accountBoList = BoTransHandler.entityListToBoList(com.eilikce.osm.core.bo.transformable.Account.class, accountList);
		return accountBoList;
	}

	@Override
	public int addAccountBo(com.eilikce.osm.core.bo.transformable.Account accountBo) {
		com.eilikce.osm.entity.admin.Account account = accountBo.transToEntity(com.eilikce.osm.entity.admin.Account.class);
		int count = accountDao.insertAccount(account);
		LOG.info("插入一条账单记录，账单号：" + account.getAccountId());
		return count;
	}

}
