package com.sakshi.atm.presentation;

import java.util.Scanner;

import com.sakshi.atm.entity.Card;
import com.sakshi.atm.service.CardService;
import com.sakshi.atm.service.CardServiceImpl;
import com.sakshi.atm.validation.Validation;

public class Login {

	    private static Scanner scanner = new Scanner(System.in);
	    private static String cardNumber;
	    private static String pin;
	    private static CardService cardService = new CardServiceImpl();
	    private static Card card;
	    private static Boolean flagCard = true;
	    private static Boolean flagPin = true;
	    private static Integer countPin = 0;

	    public static Card getLogInDetails() {
	    	
	        System.out.println("                                      =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\n");
	        
	        System.out.println("                                      ~~~~~~~~~~~~~~~~>>> WELCOME TO ATM SYSTEM <<<~~~~~~~~~~~~~~~~~~\n");
	        
	        System.out.println("                                      =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\n\n");
	        
	        while (flagCard) {
	            System.out.println("Enter Card Number: ");
	            cardNumber = scanner.nextLine();

	            if (Validation.checkCardNo(cardNumber)) {
	                card = cardService.getCardNumber(cardNumber);

	                if (card != null) {
	                    flagCard = false;
	                } else {
	                    System.out.println("Invalid Card No. Please try again.");
	                }
	            } else {
	                System.out.println("Invalid Card No. Please try again.");
	            }
	        }

	        while (flagPin) {
	            System.out.println("Enter PIN: ");
	            pin = scanner.nextLine();

	            if (Validation.checkPinNo(pin, card.getCardPin())) {
	                flagPin = false;
	            } else {
	                countPin++;
	                if (countPin < 3) {
	                    System.out.println("Invalid PIN. Please try again.");
	                } else {
	                    System.out.println("Card is blocked.");
	                    cardService.updateCardStatus(card);
	                    flagCard = false;
	                    flagPin = false;
	                }
	            }
	        }
	        return card;
	    }
	}

