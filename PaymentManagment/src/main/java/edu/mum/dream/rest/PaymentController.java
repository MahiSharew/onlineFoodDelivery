package edu.mum.dream.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import edu.mum.dream.dao.OrderDao;
import edu.mum.dream.domain.CreditCard;
import edu.mum.dream.domain.Payment;
import edu.mum.dream.domain.Payment.OrderStatus;
import edu.mum.dream.service.PaymentService;
import net.bytebuddy.implementation.bytecode.Throw;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	OrderDao orderDao;

	@PostMapping
	public void save(@RequestBody Payment payment) {
		// payment.setOrder(orderDao.findOne(payment.getOrder().getId()));
		paymentService.save(payment);
	}

	@HystrixCommand(fallbackMethod = "failureMakePayment")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> makePayment(@RequestBody Payment payment) {
		
		try {
			
			System.out.println("********:::::::::::::::"+payment.getCustomerId());
			if (paymentService.checkCard(payment.getCustomerId())) {
				
				
				if (checkCardValidity(payment)) {
					payment.setId(0);
					
					payment.setOrderStatus(OrderStatus.Paid);
					LocalDateTime paymentTime = LocalDateTime.now();
					payment.setPaymentTime(paymentTime);
					paymentService.save(payment);
					return new ResponseEntity<Payment>(payment, HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("You card has been Expired", HttpStatus.BAD_REQUEST);
				}
			}
			return new ResponseEntity<String>("Invalid card information", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("something went wrong, customer not found or doesn't have credit card", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> failureMakePayment(@RequestBody Payment payment, Throwable e) {
		return new ResponseEntity<String>("Customer service is temporarily unaivaible", HttpStatus.BAD_REQUEST);
	}

	public boolean checkCardValidity(Payment payment) {
		CreditCard card = paymentService.getCard(payment.getCustomerId());
		System.out.print("***************************"+ payment.getCustomerId());
		LocalDate ld = LocalDate.now();
		int expMonth = Integer.parseInt(card.getExpiryMonth());
		int expYear = Integer.parseInt(card.getExpiryYear());
		int todMonth = ld.getMonthValue();
		int todYear = ld.getYear();

		if (expYear >= todYear) {
			if (expMonth >= todMonth) {
				return true;
			}
		}

		return false;
	}

	@PutMapping
	public Payment update(@RequestBody Payment payment) {
		return paymentService.update(payment);
	}

	@GetMapping
	public List<Payment> findAll() {
		return paymentService.findAll();
	}

	@GetMapping("/{id}")
	public Payment findOne(@PathVariable Long id) {
		return paymentService.findOne(id);
	}
}
