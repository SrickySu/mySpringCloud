package com.surichard.myService1.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
	
	@Value("${spring.rabbitmq.routing_key.testKey}")
	private String testRoutingKey;

	@Value("${spring.rabbitmq.queue.testQueue}")
	private String testQueue;
	
	private static final String TOPIC_EXCHANGE = "topicExchange";

	@Bean
	public Exchange topicExchange() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	public Queue testQueue() {
		return new Queue(testQueue);
	}
	
	@Bean
	public Binding bindingExchange(@Qualifier("testQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(testRoutingKey);
	}
	
}
