package edu.mum.dream.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "creditcard_ID")
	private Long id;
	
	//@Size(max=5, message="{Max.cardNumber.zipCode.length }")
    private String cardNumber;
	//@NotEmpty(message= "{Min.card.expiryMonth}")
    private String expiryMonth;
	//@NotEmpty(message= "{Min.card.expiryYear}")
    private String expiryYear;
	//@NotEmpty(message= "{Min.card.expiryCode}")
    private String securityCode;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	//@Valid
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
