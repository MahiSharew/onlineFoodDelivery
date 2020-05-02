package edu.mum.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dream.dao.RestaurantDao;
import edu.mum.dream.domain.FoodMenu;
import edu.mum.dream.domain.Restaurant;
import edu.mum.dream.service.RestaurantService;


@Service
@Transactional

public class RestaurantServiceImpl implements RestaurantService{
	@Autowired
	private RestaurantDao restaurantDao;

    public void save(Restaurant restaurant) {  		
    	restaurantDao.save(restaurant);
	}
    
    public Restaurant update(Restaurant restaurant) {  		
		return restaurantDao.update(restaurant);
	}
	
  	
	public List<Restaurant> findAll() {
		return (List<Restaurant>)restaurantDao.findAll();
	}

	public Restaurant findOne(Long id) {
		return restaurantDao.findOne(id);
	}
	
	public List<FoodMenu>showFoodMenu(Long restaurantId){
		
		return restaurantDao.showFoodMenu(restaurantId);
	}
}
