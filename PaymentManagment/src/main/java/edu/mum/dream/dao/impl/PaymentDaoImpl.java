package edu.mum.dream.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.PaymentDao;
import edu.mum.dream.domain.Payment;
@Repository("PaymentDao")
public class PaymentDaoImpl  extends GenericDaoImpl<Payment> implements PaymentDao{
	public PaymentDaoImpl() {
		super.setDaoType(Payment.class);
	}
}
