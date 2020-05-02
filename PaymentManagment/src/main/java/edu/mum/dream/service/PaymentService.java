package edu.mum.dream.service;

import java.util.List;

import edu.mum.dream.domain.CreditCard;
import edu.mum.dream.domain.Payment;

public interface PaymentService {
	public void save(Payment payment);
	public Payment update(Payment payment);
	public List<Payment> findAll();
	public Payment findOne(Long id);
	public void publish(Payment payment);
	boolean checkCard(long customerId);
	
	CreditCard getCard(long customerId);
}
