package com.sakshi.atm.presentation;

import com.sakshi.atm.entity.Account;
import com.sakshi.atm.entity.Card;

public interface App {

	void deposit();
    void withdraw();
	void checkBalance(Card card);
	void miniStatement(Card card);
    void changePin(Card card);
	
}
