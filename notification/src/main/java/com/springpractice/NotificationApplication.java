package com.springpractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.autoconfig.instrument.messaging.SleuthMessagingProperties.Rabbit;
import org.springframework.context.annotation.Bean;

import com.amqp.RabbitMQMessageProducer;

@SpringBootApplication(
    scanBasePackages = {
        "com.amqp",
        "com.springpractice",
    }
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
    // @Bean
    // CommandLineRunner commandLinerRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
    //     return args -> {
    //         producer.publish(new Person("Ali", 18), notificationConfig.getInternalExchange(),
    //         notificationConfig.getInternalNotificationRoutingKey());
    //     };
    // }
    // record Person(String name, int age) {}
}