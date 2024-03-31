package com.springpractice.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(
    scanBasePackages = {
        "com.springpractice.app",
        "com.amqp"
    }
)
@EnableFeignClients(
    basePackages = {"com.springpractice.fraud", "com.springpractice.notification"}
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}