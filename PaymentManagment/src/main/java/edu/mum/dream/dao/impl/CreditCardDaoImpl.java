package edu.mum.dream.dao.impl;
 
import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.CreditCardDao; 
import edu.mum.dream.domain.CreditCard;

@Repository("creditCardDao")
public class CreditCardDaoImpl  extends GenericDaoImpl<CreditCard> implements CreditCardDao {
	public CreditCardDaoImpl() {
		super.setDaoType(CreditCard.class);
	}
}
