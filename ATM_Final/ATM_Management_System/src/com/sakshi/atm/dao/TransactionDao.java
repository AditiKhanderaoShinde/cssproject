package com.sakshi.atm.dao;

import java.util.List;

import com.sakshi.atm.entity.Transaction;

public interface TransactionDao {
    
    List<Transaction> getTransactionsForAccount(String accountNumber);
    
    String addTransaction(Transaction transaction);
}
