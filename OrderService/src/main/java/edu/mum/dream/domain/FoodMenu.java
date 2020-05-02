package edu.mum.dream.domain;

public class FoodMenu {

	private Long Id;
	private String foodName;
	private String foodDescription;
	private String foodCatalog;
	private double foodPrice;
	private Long resturantId;

	public FoodMenu() {
	}

	public Long getResturantId() {
		return resturantId;
	}

	public void setResturantId(Long resturantId) {
		this.resturantId = resturantId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public String getFoodCatalog() {
		return foodCatalog;
	}

	public void setFoodCatalog(String foodCatalog) {
		this.foodCatalog = foodCatalog;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

}
