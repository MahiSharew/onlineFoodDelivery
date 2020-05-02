package edu.mum.dream.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order {
	 public enum OrderStatus {
	        Created, Processing, Paid, Finished, Canceled
	    }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private Long Id;
	private float totalAmount;
	private Date timeStamp;
	private OrderStatus orderStatus = OrderStatus.Created;
	

	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
	//private List<CreditCard> creditCard;
	
//	@ManyToOne
//	@JoinTable ( name="CUSTOMER_ORDER") 
//	private Customer customer;


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
