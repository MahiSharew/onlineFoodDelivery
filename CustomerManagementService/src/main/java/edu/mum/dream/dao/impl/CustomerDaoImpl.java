package edu.mum.dream.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.CustomerDao;
import edu.mum.dream.domain.Customer;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao{

	public CustomerDaoImpl() {
		super.setDaoType(Customer.class);
	}
	
}
