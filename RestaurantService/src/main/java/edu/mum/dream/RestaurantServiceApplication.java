package edu.mum.dream;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import edu.mum.dream.amqp.listener.OrderMessageListener;

@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy
public class RestaurantServiceApplication {

	public final static String ORDER_MESSAGE_QUEUE = "FoodOrder_Message_Queue";
	public final static String ORDER_COMPLETED_MESSAGE_QUEUE = "FoodOrder_Completed_Queue";

	@Bean
	Queue queue() {
		return new Queue(ORDER_MESSAGE_QUEUE, true);
	}

	@Bean
	public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public SimpleMessageListenerContainer directListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(ORDER_MESSAGE_QUEUE);
		container.setMessageListener(new MessageListenerAdapter(queueListener(), "listenOrderMessage"));
		return container;
	}

	@Bean
	OrderMessageListener queueListener() {
		return new OrderMessageListener();
	}

	/********
	 * 
	 * this one is for sending message for completed order
	 */

	@Bean
	Queue queueOrderComplete() {
		return new Queue(ORDER_COMPLETED_MESSAGE_QUEUE, true);
	}

	@Bean
	DirectExchange exchangeComplete() {
		return new DirectExchange("FoodOrder_Completed_Exchange");
	}

	@Bean
	Binding binding(Queue queueOrderComplete, DirectExchange exchangeComplete) {
		return BindingBuilder.bind(queueOrderComplete).to(exchangeComplete).with(ORDER_COMPLETED_MESSAGE_QUEUE);
	}

	@Bean
	public RabbitTemplate orderCompletedTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate orderCompletedTemplate = new RabbitTemplate(connectionFactory);
		orderCompletedTemplate.setRoutingKey(ORDER_COMPLETED_MESSAGE_QUEUE);
		orderCompletedTemplate.setExchange("FoodOrder_Completed_Exchange");
		orderCompletedTemplate.setReplyTimeout(2000);
		return orderCompletedTemplate;
	}
	/*
	 * 
	 * @Bean SimpleMessageListenerContainer container(ConnectionFactory
	 * connectionFactory, MessageListenerAdapter listenerAdapter) {
	 * SimpleMessageListenerContainer container = new
	 * SimpleMessageListenerContainer();
	 * container.setConnectionFactory(connectionFactory);
	 * container.setQueueNames(ORDER_MESSAGE_QUEUE);
	 * container.setMessageListener(listenerAdapter); return container; }
	 * 
	 * @Bean MessageListenerAdapter listenerAdapter(OrderMessageListener
	 * orderMessageListener) { return new
	 * MessageListenerAdapter(orderMessageListener, "listenOrderMessage"); } /*
	 * 
	 * @Bean DirectStoreListener queueListener() { return new DirectStoreListener();
	 * }
	 */

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

}
