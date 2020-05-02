package edu.mum.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dream.dao.CreditCardDao;
import edu.mum.dream.domain.CreditCard;
import edu.mum.dream.service.CreditCardService;
@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	CreditCardDao creditCardDao;

	@Override
	public void save(CreditCard creditCard) {
		creditCardDao.save(creditCard);
		
	}

	@Override
	public CreditCard update(CreditCard creditCard) {
		return creditCardDao.update(creditCard);
	}

	@Override
	public List<CreditCard> findAll() {
		return creditCardDao.findAll();
	}

	@Override
	public CreditCard findOne(Long id) {
		return creditCardDao.findOne(id);
	}
}
