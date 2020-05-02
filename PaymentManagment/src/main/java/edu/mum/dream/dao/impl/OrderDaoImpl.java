package edu.mum.dream.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.OrderDao;
import edu.mum.dream.domain.Order;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	public OrderDaoImpl() {
		super.setDaoType(Order.class);
	}
}
