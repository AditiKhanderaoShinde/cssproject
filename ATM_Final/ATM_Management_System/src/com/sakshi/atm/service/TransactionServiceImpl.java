package com.sakshi.atm.service;

import java.util.List;

import com.sakshi.atm.dao.TransactionDao;
import com.sakshi.atm.entity.Transaction;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public List<Transaction> getTransactionsForAccount(String accountNumber) {
        return transactionDao.getTransactionsForAccount(accountNumber);
    }

    @Override
    public String addTransaction(Transaction transaction) {
        return transactionDao.addTransaction(transaction);
    }
}
