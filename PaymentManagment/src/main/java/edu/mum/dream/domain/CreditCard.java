package edu.mum.dream.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "creditcard_ID")
	private Long id;
	
//	@Max(16)
    private String cardNumber;
//    private String cardHolderName;
    private String expiryMonth;
    private String expiryYear;
    private String securityCode;

	@OneToOne
	private Customer cardHolder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

//	public String getCardHolderName() {
//		return cardHolderName;
//	}
//
//	public void setCardHolderName(String cardHolderName) {
//		this.cardHolderName = cardHolderName;
//	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Customer getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(Customer cardHolder) {
		this.cardHolder = cardHolder;
	}
	
	
}
