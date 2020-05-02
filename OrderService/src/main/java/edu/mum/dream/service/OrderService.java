package edu.mum.dream.service;

import java.util.List;

import edu.mum.dream.domain.Order;


public interface OrderService {
	public void save(Order order);
	public Order update(Order order);
	public List<Order> findAll();
	public Order findOne(Long id);
	public List<Order> findOneByUserId(Long userId);
	public List<Order> findAllSubSelect();
	
}
