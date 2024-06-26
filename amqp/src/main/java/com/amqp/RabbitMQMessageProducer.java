package com.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// class allows to publish messages to RabbitMQ exchanges and queues
@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {
    private final AmqpTemplate amqpTemplate;
    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing to {} using routingKey{}. Payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Publishing to {} using routingKey{}. Payload: {}", exchange, routingKey, payload);
    }
}
