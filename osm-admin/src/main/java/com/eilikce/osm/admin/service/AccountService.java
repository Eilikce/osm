package com.eilikce.osm.admin.service;

import java.util.ArrayList;
import java.util.List;

import com.eilikce.osm.dao.AccountDao;
import com.eilikce.osm.entity.admin.AccountPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.handler.BoTransHandler;

@Service
public class AccountService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private AccountDao accountDao;
	
	public int findCount() {
		int count = accountDao.selectCount();
		return count;
	}

	public List<com.eilikce.osm.core.bo.transformable.Account> findAccountList() {
		List<com.eilikce.osm.core.bo.transformable.Account> accountBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.Account>();
		List<AccountPo> accountPoList = accountDao.selectAllAccount();
		accountBoList = BoTransHandler.entityListToBoList(com.eilikce.osm.core.bo.transformable.Account.class, accountPoList);
		return accountBoList;
	}

	public int addAccountBo(com.eilikce.osm.core.bo.transformable.Account accountBo) {
		AccountPo accountPo = accountBo.transToEntity(AccountPo.class);
		int count = accountDao.insertAccount(accountPo);
		LOG.info("插入一条账单记录，账单号：" + accountPo.getAccountId());
		return count;
	}

}
