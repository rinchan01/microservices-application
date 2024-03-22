package com.springpractice.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.springpractice.NotificationService;
import com.springpractice.notification.NotificationRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
            log.info("Consumed {} from queue");
            notificationService.sendNotification(notificationRequest);
        
    }
}
