package edu.mum.dream.service;

import java.util.List;

import edu.mum.dream.domain.CreditCard;
 
public interface CreditCardService {

	public void save(CreditCard creditCard);
	public CreditCard update(CreditCard creditCard);
	public List<CreditCard> findAll();
	public CreditCard findOne(Long id);
	
}
