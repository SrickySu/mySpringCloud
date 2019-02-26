package com.surichard.myService1.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.surichard.myService1.service.QueueTestService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QueueTestServiceImpl implements QueueTestService {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Autowired
	private Exchange topicExchange;
	
	@Value("${spring.rabbitmq.routing_key.testKey}")
	private String testRoutingKey;

	@Override
	public void sendMessage(String content) {
		amqpTemplate.convertAndSend(topicExchange.getName(), testRoutingKey, content);
		log.info("send a message through rabbitmq: {}", content);
	}

}
