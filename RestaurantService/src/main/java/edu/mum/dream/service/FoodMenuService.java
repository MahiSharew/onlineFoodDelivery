package edu.mum.dream.service;

import java.util.List;

import edu.mum.dream.domain.FoodMenu;


public interface FoodMenuService {
	public void save(FoodMenu foodMenu);
	public FoodMenu update(FoodMenu foodMenu);
	public List<FoodMenu> findAll();
	public FoodMenu findOne(Long id);
	public List<FoodMenu >findAllMenuByResturantID(Long resturantId);
}
