package com.sakshi.atm.service;

import com.sakshi.atm.dao.CardDao;
import com.sakshi.atm.dao.CardDaoImpl;
import com.sakshi.atm.entity.Card;

public class CardServiceImpl implements CardService {
	
	CardDao cardDao = new CardDaoImpl();

	@Override
	public Card getCardNumber(String cardNumber) {
		
		return cardDao.getCardNumber(cardNumber);
	}

	@Override
	public String updateCardStatus(Card card) {
		
		return cardDao.updateCardStatus(card);
	}

	@Override
    public String updateCardPin(Card card) {
        try {
            String status = cardDao.updateCardPin(card);
            return status;
        } catch (Exception e) {
            
            return "Failed to update PIN";
        }
    }
}