package com.sakshi.atm.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Account {
    @Id    
    @Column(length=17)
    private String accountNumber;
    @Column(length=20)
    private String accountType;
    private double balance;
    @Column(length=9)
    private String status;
    private Date openingDate;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Card> card = new ArrayList<>();
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transaction = new ArrayList<>();
    
    public Account() {
        this.card = new ArrayList<>();
        this.transaction= new ArrayList<>();
    }

    public Account(String accountNumber, String accountType, double balance, String status, Date openingDate) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.openingDate = openingDate;
    }
 
    public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer =  customer;
    }

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
    
    

}
