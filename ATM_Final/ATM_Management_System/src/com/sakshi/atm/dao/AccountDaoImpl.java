package com.sakshi.atm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.sakshi.atm.entity.Account;

public class AccountDaoImpl implements AccountDao {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private AccountDao accountDao;

	public AccountDaoImpl() {
		super();
		entityManager = MyConnection.getEntityManagerObject();
	}
	
	@Override
	public Account getBalance(Account account, Double balance) {
		return entityManager.find(Account.class, balance);
	}
	
	@Override
	public Account updateAccount(Account account) {
	    entityTransaction = entityManager.getTransaction();

	    try {
	        if (entityTransaction != null) {
	            entityTransaction.begin();
	            Account updatedAccount = entityManager.merge(account);
	            entityTransaction.commit();
	            return updatedAccount;
	        } else {
	            throw new IllegalStateException("EntityTransaction is null");
	        }
	    } catch (Exception e) {
	        if (entityTransaction != null && entityTransaction.isActive()) {
	            entityTransaction.rollback();
	        }
	        e.printStackTrace();
	        throw new RuntimeException("Error updating account", e);
	    }
	}

	
}
	
