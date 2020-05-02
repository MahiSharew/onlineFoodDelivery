package edu.mum.dream.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FoodItem")
public class FoodItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FOODITEM_ID")
	private Long Id;

	@NotNull( message = "{Min.number.FOODMENU_ID}")
	@Column(name = "FOODMENU_ID")
	private Long foodMenuID;

	@NotNull
	@Size(min = 4, max = 32, message = "{Size.name.validation.foodName}")
	private String foodName;

	@NotNull( message = "{Min.number.foodPrice}")
	private double foodPrice;

	@NotNull
	@Min(value = 1, message = "{Min.number.quantity}")
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
