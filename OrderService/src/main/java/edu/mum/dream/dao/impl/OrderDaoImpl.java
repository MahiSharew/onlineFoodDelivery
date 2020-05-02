package edu.mum.dream.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.OrderDao;
import edu.mum.dream.domain.Order;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	@PersistenceContext
	protected EntityManager entityManager;

	public OrderDaoImpl() {
		super.setDaoType(Order.class);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOneByUserId(Long userId) {
		System.out.println(userId);
		Query query = entityManager.createQuery("select r from  Order  r  " + "where r.userName =:userId");
		return (List<Order>) query.setParameter("userId", userId).getResultList();
	}

	public List<Order> findAllSubSelect() {
		// hydrate since LAZY load
		List<Order> orders = (List<Order>) this.findAll();
		orders.get(0).getFoodItem().get(0);

		return orders;

	}

}
