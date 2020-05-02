package edu.mum.dream.domain;

import java.util.List;

public class Restaurant {

	private Long Id;
	private String restaurantName;
	private String restaurantCatalog;
	private List<FoodMenu> foodMenu;

	public Restaurant() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantCatalog() {
		return restaurantCatalog;
	}

	public void setRestaurantCatalog(String restaurantCatalog) {
		this.restaurantCatalog = restaurantCatalog;
	}

	public List<FoodMenu> getFoodMenu() {
		return foodMenu;
	}

	public void setFoodMenu(List<FoodMenu> foodMenu) {
		this.foodMenu = foodMenu;
	}

}
