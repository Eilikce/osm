package com.eilikce.osm.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.transformable.Account;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.dao.AccountDao;
import com.eilikce.osm.entity.admin.AccountPo;

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
	public List<Account> findAccountList() {
		List<Account> accountBoList = new ArrayList<Account>();
		List<AccountPo> accountList = accountDao.selectAllAccount();
		accountBoList = BoTransHandler.entityListToBoList(Account.class, accountList);
		return accountBoList;
	}

	@Override
	public int addAccountBo(Account accountBo) {
		AccountPo account = accountBo.transToEntity(AccountPo.class);
		int count = accountDao.insertAccount(account);
		LOG.info("插入一条账单记录，账单号：" + account.getAccountId());
		return count;
	}

}
