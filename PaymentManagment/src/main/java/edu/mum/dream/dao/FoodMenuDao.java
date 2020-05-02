package edu.mum.dream.dao;

import java.util.List;

import edu.mum.dream.domain.CreditCard;

public interface FoodMenuDao extends GenericDao<CreditCard>{

	public List<CreditCard >findAllMenuByResturantID(Long resturantId);
	

}
