package edu.mum.dream.service;

import java.util.List;

import edu.mum.dream.domain.CreditCard;


public interface FoodMenuService {
	public void save(CreditCard foodMenu);
	public CreditCard update(CreditCard foodMenu);
	public List<CreditCard> findAll();
	public CreditCard findOne(Long id);
	public List<CreditCard >findAllMenuByResturantID(Long resturantId);
}
