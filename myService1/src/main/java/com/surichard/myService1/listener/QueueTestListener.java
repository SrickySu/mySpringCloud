package com.surichard.myService1.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class QueueTestListener {
	
	@RabbitListener(queues = "${rabbitmq.queue.testQueue}")
	public void receiveMessage(Message message) {
		log.info("receive a message from rabbitmq: {}", new String(message.getBody()));
	}

}
