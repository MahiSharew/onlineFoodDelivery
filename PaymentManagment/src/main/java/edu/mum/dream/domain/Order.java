package edu.mum.dream.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum OrderStatus {
		Created, Processing, Paid, Finished, Cancelld
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private Long Id;

	@NotNull(message = "{Min.number.userName}")
	private Long userName;

	@NotNull(message = "{Min.number.restaurantId}")
	private Long restaurantId;

	@NotNull(message = "{Size.name.validation}")
	private String restaurantName;

	@Column(name = "order_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime orderTime = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus = OrderStatus.Created;
	@NotNull
	@Min(value = 1, message = "{Min.number.totalPrice}")
	private double totalPrice;


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

	

}
