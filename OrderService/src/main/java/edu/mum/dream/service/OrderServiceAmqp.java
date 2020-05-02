package edu.mum.dream.service;



import edu.mum.dream.domain.Order;

public interface OrderServiceAmqp {
	
	public void publish(Order order);
	
//	public void publishPayment(Order order);

}
