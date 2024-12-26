package com.sakshi.atm.service;

import java.util.List;

import com.sakshi.atm.dao.TransactionDao;
import com.sakshi.atm.entity.Transaction;

public interface TransactionService {
    List<Transaction> getTransactionsForAccount(String accountNumber);
    String addTransaction(Transaction transaction);
}
