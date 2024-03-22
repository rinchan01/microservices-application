package com.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.MessageConverter;


import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {
    private final ConnectionFactory connectionFactory;
    // publish a msg to a queue
    @Bean
    public AmqpTemplate amqpTemplate() {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // send msg as json format
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        // receive msg as json format
        factory.setMessageConverter(messageConverter());
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() {
        MessageConverter jackson2MessageConverter = new Jackson2JsonMessageConverter();
        return jackson2MessageConverter;
    }
}
