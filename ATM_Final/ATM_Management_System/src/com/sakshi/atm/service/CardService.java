package com.sakshi.atm.service;

import com.sakshi.atm.entity.Card;

public interface CardService {
	
	public Card getCardNumber(String cardNumber);
	
	public String updateCardStatus(Card card);
	
	 String updateCardPin(Card card);

}