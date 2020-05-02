package edu.mum.dream.service;

import java.util.Locale;

import javax.mail.MessagingException;

import edu.mum.dream.domain.Order;

public interface EmailService {
	public void sendOrderReceivedMail(final String recipientName, final String recipientEmail, Order order,
			 final Locale locale) throws MessagingException ;

}
