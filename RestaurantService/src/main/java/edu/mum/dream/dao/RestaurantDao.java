package edu.mum.dream.dao;



import java.util.List;

import edu.mum.dream.domain.FoodMenu;
import edu.mum.dream.domain.Restaurant;

public interface RestaurantDao extends GenericDao<Restaurant> {
	
	public List<FoodMenu>showFoodMenu(Long restaurantId);
}
