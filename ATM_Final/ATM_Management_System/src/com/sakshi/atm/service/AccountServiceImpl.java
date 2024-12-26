package com.sakshi.atm.service;

import com.sakshi.atm.dao.AccountDaoImpl;
import com.sakshi.atm.entity.Account;
import com.sakshi.atm.dao.AccountDao;

public class AccountServiceImpl implements AccountService{
	
	private final AccountDao accountDao;

	public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

	@Override
	public Account updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	
}
