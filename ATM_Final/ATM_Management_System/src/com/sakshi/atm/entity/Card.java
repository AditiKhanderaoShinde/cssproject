package com.sakshi.atm.entity;
import javax.persistence.*;

import com.sakshi.atm.dao.CardDao;
import com.sakshi.atm.dao.CardDaoImpl;

import java.util.Date;

@Entity
public class Card {
    @Id
    @Column(length=16)
    private String cardNumber;
    @Column(length=15)
    private String cardType;
    private Date expiryDate;
    private Date issueDate;
    @Column(length=4)
    private Integer cvvNumber;
    @Column(length=4)
    private String cardPin;
    @Column(length=10)
    private String cardStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountNumber")
    private Account account;

    public Card() {}
    public Card(String cardNumber, String cardType, Date expiryDate, Date issueDate,
                Integer cvvNumber, String cardPin, String cardStatus) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.issueDate = issueDate;
        this.cvvNumber = cvvNumber;
        this.cardPin = cardPin;
        this.cardStatus = cardStatus;
    }
        
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
	public String getCardPin() {
		return cardPin;
	}
	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}    
}
