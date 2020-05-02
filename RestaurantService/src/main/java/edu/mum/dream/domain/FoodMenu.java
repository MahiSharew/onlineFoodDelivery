package edu.mum.dream.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "FoodMenu")
public class FoodMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FOODMENU_ID")
	private Long Id;
	@NotNull
	@Size(min = 4, max = 32, message = "{Size.foodName}")
	private String foodName;
	@NotNull
	@Size(min = 4, max = 32, message = "{Size.foodDescription}")
	
	private String foodDescription;
	
	@NotNull
	@Size(min = 4, max = 32, message = "{Size.foodCatalog}")
	private String foodCatalog;
	
	@NotNull(message = "{Size.foodPrice}")
	private double foodPrice;

	

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
