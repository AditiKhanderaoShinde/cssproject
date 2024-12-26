package com.sakshi.atm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.sakshi.atm.entity.Transaction;

public class TransactionDaoImpl implements TransactionDao {
    private EntityManager entityManager;
    public TransactionDaoImpl() {
		super();
		entityManager = MyConnection.getEntityManagerObject();
	}


    
    @Override
    public List<Transaction> getTransactionsForAccount(String accountNumber) {
        Query query = entityManager.createQuery("SELECT t FROM Transaction t WHERE t.account.accountNumber = :accountNumber");
        query.setParameter("accountNumber", accountNumber);
        return query.getResultList();
    }



    @Override
    public String addTransaction(Transaction transaction) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            if (entityTransaction != null) {
                entityTransaction.begin();
                entityManager.persist(transaction);
                entityTransaction.commit();
                return "Transaction added successfully";
            } else {
                return "Failed to add transaction: EntityTransaction is null";
            }
        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
            return "Failed to add transaction: " + e.getMessage();
        }
    }
}