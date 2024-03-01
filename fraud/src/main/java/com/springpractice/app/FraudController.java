package com.springpractice.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.fraud.FraudCheckResponse;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;
    
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudulent(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulent = fraudCheckService.isFraud(customerId);
        return new FraudCheckResponse(isFraudulent);
    }
    
}
