package edu.mum.dream.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//@Entity
public class Customer  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private long id;

	@Column(length = 16)
	private String firstName;
	@Column(length = 16)
	private String lastName;

	// @OneToOne(fetch=FetchType.EAGER)
	// @JoinColumn(name="memberId")
	// UserCredentials userCredentials;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<Order> orders = new HashSet<Order>();
	//@OneToMany(targetEntity=Order.class, mappedBy="customer", fetch=FetchType.EAGER)
	//@OneToMany (mappedBy="customer") 
	//private Set<Order> orders;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}
