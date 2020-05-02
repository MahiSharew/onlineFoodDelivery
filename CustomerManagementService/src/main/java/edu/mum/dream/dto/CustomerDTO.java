package edu.mum.dream.dto;

import edu.mum.dream.domain.Address;
import edu.mum.dream.domain.CreditCard;
import edu.mum.dream.domain.Customer;

public class CustomerDTO {

	private Customer customer;
	private Address address;
	private CreditCard creditCard;
	
	public CustomerDTO() {
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}
