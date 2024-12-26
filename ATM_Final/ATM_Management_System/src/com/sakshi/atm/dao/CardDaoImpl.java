package com.sakshi.atm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.sakshi.atm.entity.Card;

public class CardDaoImpl implements CardDao {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public CardDaoImpl() {
		super();
		entityManager = MyConnection.getEntityManagerObject();
	}

	@Override
	public Card getCardNumber(String cardNumber) {
			return entityManager.find(Card.class, cardNumber);
	}

	@Override
	public Card getCardPin(String cardPin) {
		return entityManager.find(Card.class, cardPin);
	}

	@Override
	public String updateCardStatus(Card card) {
		
		entityTransaction = entityManager.getTransaction();
		Card card1 = entityManager.find(Card.class,card.getCardNumber());
		entityTransaction.begin();
		   card1.setCardStatus("Deactive"); 
		   entityManager.persist(card1);
	  entityTransaction.commit();
		return "Updated";
	}

	@Override
    public String updateCardPin(Card card) {
		 try {
		        entityTransaction = entityManager.getTransaction();
		        entityTransaction.begin();

		        Card cardToUpdate = entityManager.find(Card.class, card.getCardNumber());

		        cardToUpdate.setCardPin(card.getCardPin());

		        entityManager.persist(cardToUpdate);

		        entityTransaction.commit();

		        return "PIN updated successfully";
		    } catch (Exception e) {
		     if (entityTransaction != null && entityTransaction.isActive()) {
		          
		            entityTransaction.rollback();
		        }
		        return "Failed to update PIN";
		    }
		}
    }
