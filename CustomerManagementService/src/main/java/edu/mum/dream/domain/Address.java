package edu.mum.dream.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Address {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
    
    @Column(length = 20)
	//@NotEmpty(message = "{Min.address.street}")
 	private String street;
    
    @Column(length = 16)
	//@NotEmpty(message = "{Min.address.city}")
	private String city;
    
    @Column(length = 8)
	//@NotEmpty(message = "{Min.address.state}")
 	private String state;
    
    @Column(length = 6)
	//@NotEmpty(message= "{Min.address.zipCode}")
   // @Size(max=5, message="{Max.address.zipCode.length }")
  	private String zipCode;

//  	@ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn (name="member_id") 
//  	private Member  member;
  	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
