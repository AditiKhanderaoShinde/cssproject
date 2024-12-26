package com.sakshi.atm.dao;

import com.sakshi.atm.entity.Card;

public interface CardDao {
	
	Card getCardNumber(String cardNumber);

	Card getCardPin(String cardPin);
	
	String updateCardStatus(Card card);
	
	String updateCardPin(Card card);
	
	
}