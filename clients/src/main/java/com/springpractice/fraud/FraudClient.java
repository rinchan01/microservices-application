package com.springpractice.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fraud", url = "http://fraud.default.svc.cluster.local")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId);

}