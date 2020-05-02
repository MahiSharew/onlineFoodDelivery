package edu.mum.dream.dao;

import java.util.List;

import edu.mum.dream.domain.FoodMenu;

public interface FoodMenuDao extends GenericDao<FoodMenu>{

	public List<FoodMenu >findAllMenuByResturantID(Long resturantId);
	

}
