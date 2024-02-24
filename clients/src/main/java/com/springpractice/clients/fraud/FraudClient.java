package com.springpractice.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "fraud-service")
public interface FraudClient {
    
}
