package edu.mum.dream.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.mum.dream.domain.Order;
import edu.mum.dream.domain.Order.OrderStatus;
import edu.mum.dream.domain.Payment;
import edu.mum.dream.domain.Restaurant;
import edu.mum.dream.service.OrderService;
import edu.mum.dream.service.OrderServiceAmqp;

@RestController
@RequestMapping("/api")
public class OrderRestContoller {

	private RestTemplate restTemplate;

	private OrderService orderService;

	private OrderServiceAmqp orderServiceAmpq;
	private String paymentManagmentUrl = "http://Payment-Microservice/payment/save";

	@Autowired
	public OrderRestContoller(RestTemplate restTemplate, OrderService orderService, OrderServiceAmqp orderServiceAmpq) {
		this.restTemplate = restTemplate;
		this.orderService = orderService;
		this.orderServiceAmpq = orderServiceAmpq;
	}

	@GetMapping("/restaurants")
	public Restaurant findallRestaurant() {
		Restaurant restaurant = restTemplate.getForObject("http://Restaurant-Microservice/api/restaurants/2/",
				Restaurant.class);
		return restaurant;
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order upload(@Valid @RequestBody Order order) {

		order.setId(null);

		orderService.save(order);

		/***
		 * check the validation of the payment by calling payment microservice send
		 * order information
		 * 
		 ***/
		Payment payment = new Payment();
		payment.setId(0);
		payment.setOrderId(order.getId());
		payment.setTotalPrice(order.getTotalPrice());
		payment.setCustomerId(order.getUserName());
		Payment paymentreturn = restTemplate.postForObject(paymentManagmentUrl, payment, Payment.class);
		if(paymentreturn.getOrderStatus()==Payment.OrderStatus.Paid) {
			order.setOrderStatus(OrderStatus.Paid);
			orderService.update(order);
			orderServiceAmpq.publish(order);
		}
		return order;
		
		
	}

	/***
	 * get All orders API
	 * 
	 *
	 ***/
	@GetMapping("/orders")
	public List<Order> findallOrder() {
		return orderService.findAllSubSelect();
	}

	/***
	 * get all order By orderId
	 * 
	 *
	 ***/

	@GetMapping("/orders/{orderId}")
	public Order getOrderByOrderID(@PathVariable int orderId) {
		return orderService.findOne((long) orderId);
	}

	/***
	 * get all order By UserID
	 * 
	 *
	 ***/
	
	
	@GetMapping("/{userId}/orders")
	public List<Order> getOrderByUserID(@PathVariable int userId) {
		return orderService.findOneByUserId((long) userId);
	}

}
