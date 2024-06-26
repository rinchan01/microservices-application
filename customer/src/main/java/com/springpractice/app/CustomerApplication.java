package com.springpractice.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(
    scanBasePackages = {
        "com.springpractice.app",
        "com.amqp"
    }
)
@EnableEurekaClient
@EnableFeignClients(
    basePackages = {"com.springpractice.fraud", "com.springpractice.notification"}
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}