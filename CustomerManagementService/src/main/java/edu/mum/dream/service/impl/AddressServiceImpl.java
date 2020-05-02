package edu.mum.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dream.dao.AddressDao;
import edu.mum.dream.domain.Address;
import edu.mum.dream.service.AddressService;

@Service
@Transactional 
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;

	@Override
	public void save(Address address) {
		addressDao.save(address);
	}

	@Override
	public Address update(Address address) {
		return addressDao.update(address);
	}

	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

	@Override
	public Address findOne(Long id) {
		return addressDao.findOne(id);
	}

}
