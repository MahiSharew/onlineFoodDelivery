package edu.mum.dream.service;

import java.util.List;

import edu.mum.dream.domain.FoodMenu;
import edu.mum.dream.domain.Restaurant;

public interface RestaurantService {
	public void save(Restaurant restaurant);
	public Restaurant update(Restaurant restaurant);
	public List<Restaurant> findAll();
	public Restaurant findOne(Long id);
	public List<FoodMenu>showFoodMenu(Long restaurantId);
}
