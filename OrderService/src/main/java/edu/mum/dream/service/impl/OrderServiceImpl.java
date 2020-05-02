package edu.mum.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.mum.dream.dao.OrderDao;
import edu.mum.dream.domain.Order;
import edu.mum.dream.service.OrderService;
@Service
@Transactional 
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

    public void save( Order order) {  		
    	orderDao.save(order);
	}
    
    public Order update(Order order) {  		
		return orderDao.update(order);
	}
	
  	
	public List<Order> findAll() {
		return (List<Order>)orderDao.findAll();
	}

	
	public Order findOne(Long id) {
		return orderDao.findOne(id);
	}
	public List<Order>findOneByUserId(Long id) {
		
		return orderDao.findOneByUserId(id);
	}
	
	public List<Order> findAllSubSelect(){
		
		return orderDao.findAllSubSelect();
	}
	
	

}
