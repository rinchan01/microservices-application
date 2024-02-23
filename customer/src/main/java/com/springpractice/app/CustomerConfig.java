package com.springpractice.app;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
// using rest template to make http requests from the customer service to the fraud detection service
@Configuration
public class CustomerConfig {
    @Bean
    // the request will be load balanced and be sent to one of the instances of the fraud detection service
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
