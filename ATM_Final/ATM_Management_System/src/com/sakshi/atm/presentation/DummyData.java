package com.sakshi.atm.presentation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.sakshi.atm.dao.MyConnection;
import com.sakshi.atm.entity.Account;
import com.sakshi.atm.entity.Bank;
import com.sakshi.atm.entity.Card;
import com.sakshi.atm.entity.Customer;
import com.sakshi.atm.entity.Transaction;

public class DummyData {

	public static void main(String [] args) {
		
		EntityManager entityManager = MyConnection.getEntityManagerObject();
		EntityTransaction entityTransaction = entityManager.getTransaction();
	    
		 Bank bank = new Bank("SBIN0021960", "00356", "GUNGOTI OSMANABAD");		
		    Customer customer = new Customer("C127", "Sakshi Mane", "9834698696", "Hadapsar Pune", new Date(),
		            "947524207425", "FBRPM7054R", "Female");      
		    Account account = new Account("675423456777", "Savings", 1000.0, "Active", new Date());    
		    Card card = new Card("6522940260356624", "Debit", new Date(), new Date(), 123, "0205", "Active");  
		    


	    bank.getCustomer().add(customer);
	    customer.setBank(bank);
	    customer.getAccount().add(account);
	    account.setCustomer(customer);
	    account.getCard().add(card);
	    card.setAccount(account);
	   
	    
	    entityTransaction.begin();
	    
	    entityManager.persist(bank);
	    entityManager.persist(customer);
	    entityManager.persist(account);
	    entityManager.persist(card);
	    
	    
	    entityTransaction.commit();
	 }


}