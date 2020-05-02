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
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

import edu.mum.dream.amqp.listener.OrderMessageCompletedListener;

@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy
public class OrderServiceApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getREstTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
	    LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
	    validatorFactoryBean.setValidationMessageSource(messageSource);
	    return validatorFactoryBean;
	}

	public final static String ORDER_MESSAGE_QUEUE = "FoodOrder_Message_Queue";
	
	public final static String ORDER_COMPLETED_MESSAGE_QUEUE = "FoodOrder_Completed_Queue";

	/********
	 * 
	 * Once order is payed send message to restaurant With order information and
	 * payment confirmation thought AMQP ,ORDER_MESSAGE_QUEUE
	 * ="FoodOrder_Message_Queue"
	 * 
	 ********/

	@Bean
	Queue queue() {
		return new Queue(ORDER_MESSAGE_QUEUE, true);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange("FoodOrder_Message_Exchange");
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ORDER_MESSAGE_QUEUE);
	}

	@Bean
	public RabbitTemplate orderMessageTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate orderMessageTemplate = new RabbitTemplate(connectionFactory);
		orderMessageTemplate.setRoutingKey(ORDER_MESSAGE_QUEUE);
		orderMessageTemplate.setExchange("FoodOrder_Message_Exchange");
		orderMessageTemplate.setReplyTimeout(2000);
		return orderMessageTemplate;
	}

	
	
	/********
	 * 
	 * listen a message come from restaurant microservices And call method
	 * listenOrderCompleteMessage() send an email to customer
	 * 
	 ********/

	@Bean
	Queue queueOrderComplete() {
		return new Queue(ORDER_COMPLETED_MESSAGE_QUEUE, true);
	}

	@Bean
	public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public SimpleMessageListenerContainer directListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(ORDER_COMPLETED_MESSAGE_QUEUE);
		container.setMessageListener(new MessageListenerAdapter(queueListener(), "listenOrderCompleteMessage"));
		return container;
	}

	@Bean
	OrderMessageCompletedListener queueListener() {
		return new OrderMessageCompletedListener();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
