package com.sakshi.atm.presentation;

import java.util.Scanner;

import com.sakshi.atm.dao.AccountDao;
import com.sakshi.atm.dao.AccountDaoImpl;
import com.sakshi.atm.dao.MyConnection;
import com.sakshi.atm.dao.TransactionDao;
import com.sakshi.atm.dao.TransactionDaoImpl;
import com.sakshi.atm.entity.Card;
import com.sakshi.atm.service.AccountService;
import com.sakshi.atm.service.AccountServiceImpl;
import com.sakshi.atm.service.TransactionService;
import com.sakshi.atm.service.TransactionServiceImpl;

public class MainApp {

            
    	public static void main(String[] args) {
            
    	    AccountDao accountDao = new AccountDaoImpl();
    	    TransactionDao transactionDao = new TransactionDaoImpl();

    	    AccountService accountService = new AccountServiceImpl(accountDao);
    	    TransactionService transactionService = new TransactionServiceImpl(transactionDao);
    	    
    	    App app = new AppImpl(transactionService);

    	    Card card = Login.getLogInDetails();

    	    // Check if the card has a valid account
    	    if (card.getAccount() != null) {
    	        System.out.println("Account Number: " + card.getAccount().getAccountNumber());
    	        System.out.println("Customer Name: " + card.getAccount().getCustomer().getCustomerName());
    	    } else {
    	        System.out.println("Card does not have a valid account.");
    	        return; 
    	    }

    	    Scanner scanner = new Scanner(System.in);
    	    int choice;

    	    while (true) {
    	        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
    	        System.out.println(" What Operation do you want to perform......\n");
    	        System.out.println("============================================\n");
    	        System.out.println("1. Deposit\n");
    	        System.out.println("2. Withdraw\n");
    	        System.out.println("3. Mini Statement\n");
    	        System.out.println("4. Check Balance\n");
    	        System.out.println("5. Change Pin\n");
    	        System.out.println("6. Exit\n");
    	        System.out.println("\n+++++++++++++++ Enter your choice from above +++++++++++++++++\n");

    	        choice = scanner.nextInt();

    	        switch (choice) {
    	            case 1:
    	                app.deposit();
    	                System.out.println("Deposited");
    	                break;
    	            case 2:
    	                app.withdraw();
    	                System.out.println("Withdrawn");
    	                break;
    	            case 3:
    	                app.miniStatement(card);
    	                System.out.println(" Mini Statement Generated");
    	                break;
    	            case 4:
    	            	app.checkBalance(card);
    	                System.out.println("Balance Checked.");
    	                break;
    	            case 5:
    	            	app.changePin(card);
    	                return; 
    	            case 6:
    	                System.out.println("Exiting ATM. Thank you!");
    	                return; 
    	            default:
    	                System.out.println("Invalid choice");
    	                break;
    	        }
    	    }
    	}
}