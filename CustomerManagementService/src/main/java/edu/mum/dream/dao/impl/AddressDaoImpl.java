package edu.mum.dream.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dream.dao.AddressDao;
import edu.mum.dream.domain.Address;

@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {
	public AddressDaoImpl() {
		super.setDaoType(Address.class);
	}
}
