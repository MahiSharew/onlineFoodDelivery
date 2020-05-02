package edu.mum.dream.domain;

import java.time.LocalDateTime;

public class Payment {
	public enum OrderStatus {
		Created, Processing, Paid, Finished, Cancelld
	}
	private long id;
	private long orderId;
	private long customerId;
	private LocalDateTime paymentTime = LocalDateTime.now();
	private double totalPrice;
	private OrderStatus orderStatus;
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public long getId() {
		return id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Payment() {

	}

}
