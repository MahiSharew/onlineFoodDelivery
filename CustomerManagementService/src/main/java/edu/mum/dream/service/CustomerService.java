package edu.mum.dream.service;

import java.util.List;
import edu.mum.dream.domain.Customer;

public interface CustomerService {
	public void save(Customer customer);
	public Customer update(Customer customer);
	public List<Customer> findAll();
	public Customer findOne(Long id);

}
