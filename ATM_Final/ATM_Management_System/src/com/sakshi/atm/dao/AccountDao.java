package com.sakshi.atm.dao;

import javax.persistence.EntityManager;

import com.sakshi.atm.entity.Account;

public interface AccountDao {
	
	Account getBalance(Account account , Double balance);

	Account updateAccount(Account account);
}