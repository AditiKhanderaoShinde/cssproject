package com.sakshi.atm.presentation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sakshi.atm.dao.AccountDao;
import com.sakshi.atm.dao.AccountDaoImpl;
import com.sakshi.atm.entity.Account;
import com.sakshi.atm.entity.Card;
import com.sakshi.atm.entity.Transaction;
import com.sakshi.atm.service.AccountService;
import com.sakshi.atm.service.AccountServiceImpl;
import com.sakshi.atm.service.CardService;
import com.sakshi.atm.service.CardServiceImpl;
import com.sakshi.atm.service.TransactionService;
import com.sakshi.atm.service.TransactionServiceImpl;

public class AppImpl implements App {
    private TransactionService transactionService;
    private CardService cardService = new CardServiceImpl();
    AccountDao accountDao = new AccountDaoImpl(); // Initialize your AccountDao implementation
    AccountService accountService = new AccountServiceImpl(accountDao);


    public AppImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

   

    @Override
    public void deposit() {
        Card card = Login.getLogInDetails();

        System.out.println("Enter the amount to deposit: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        Account account = card.getAccount();

        if (account != null) {
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);

            accountService.updateAccount(account);

            // Add a new transaction record for the deposit
            Transaction transaction = new Transaction();
            transaction.setDate(LocalDate.now());
            transaction.setTime(LocalTime.now());
            transaction.setTransactionType("Deposit");
            transaction.setAccount(account);
            String result = transactionService.addTransaction(transaction);
            System.out.println(result);

            System.out.println("Amount deposited successfully. New balance: " + newBalance);
        } else {
            System.out.println("Invalid card or account details.");
        }
    }

	@Override
			public void withdraw() {
		    Card card = Login.getLogInDetails(); // Get the card details from login

		    System.out.println("Enter the amount to withdraw: ");
		    Scanner scanner = new Scanner(System.in);
		    double amount = scanner.nextDouble();

		    Account account = card.getAccount();

		    if (account != null) {
		        double currentBalance = account.getBalance();
		        if (currentBalance >= amount) {
		            double newBalance = currentBalance - amount;
		            account.setBalance(newBalance);

		            // Update the account balance
		            accountService.updateAccount(account);

		            // Add a new transaction record for the withdrawal
		            Transaction transaction = new Transaction();
		            transaction.setDate(LocalDate.now());
		            transaction.setTime(LocalTime.now());
		            transaction.setTransactionType("Withdrawal");
		            transaction.setAccount(account);

		            String result = transactionService.addTransaction(transaction);
		            System.out.println(result);

		            System.out.println("Amount withdrawn successfully. New balance: " + newBalance);
		        } else {
		            System.out.println("Insufficient funds. Current balance: " + currentBalance);
		        }
		    } else {
		        System.out.println("Invalid card or account details.");
		    }
		

	}

    @Override
    public void miniStatement(Card card) {
        String accountNumber = card.getAccount().getAccountNumber();
        List<Transaction> transactions = transactionService.getTransactionsForAccount(accountNumber);

        System.out.println("Mini Statement for Account Number: " + accountNumber);
        System.out.println("-------------------------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Date: " + transaction.getDate());
            System.out.println("Time: " + transaction.getTime());
            System.out.println("Transaction Type: " + transaction.getTransactionType());
            System.out.println("-------------------------------------------------");
        }
    }


    @Override
	public void checkBalance(Card card) {
    	card=Login.getLogInDetails();
        if (card != null && card.getAccount() != null) {
            Double balance = card.getAccount().getBalance();
            System.out.println("Account balance: " + balance);
        } else {
            System.out.println("Account is null for the card");
        }
		
	}

	@Override
	public void changePin(Card card) {
		  Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter new PIN: ");
	        String newPin = scanner.nextLine();

	        System.out.println("Confirm new PIN: ");
	        String confirmPin = scanner.nextLine();

	        if (newPin.equals(confirmPin)) {
	            card.setCardPin(newPin); 
	            CardService cardService = new CardServiceImpl();
	            cardService.updateCardPin(card);
	            System.out.println("PIN changed successfully.");
	        } else {
	            System.out.println("PINs do not match. PIN change failed.");
	        }
	    }

	}



