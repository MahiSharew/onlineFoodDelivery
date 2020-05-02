package edu.mum.dream.domain;

import java.io.Serializable;


public class FoodItem  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long Id;
	private Long foodMenuID;
	private String foodName;
	private double foodPrice;
	private int quantity;
	

	public Long getFoodMenuID() {
		return foodMenuID;
	}

	public void setFoodMenuID(Long foodMenuID) {
		this.foodMenuID = foodMenuID;
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


	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
