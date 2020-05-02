package edu.mum.dream.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum OrderStatus {
		Created, Processing, Paid, Finished, Cancelld
	}


	private Long Id;
	private Long userName;
	private Long restaurantId;
	private String restaurantName;

	@Column(name = "order_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime orderTime = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus = OrderStatus.Created;
	private double totalPrice;

	

	private List<FoodItem> foodItem;

	public Long getId() {
		return Id;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getUserName() {
		return userName;
	}

	public void setUserName(Long userName) {
		this.userName = userName;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<FoodItem> getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(List<FoodItem> foodItem) {
		this.foodItem = foodItem;
	}

}
