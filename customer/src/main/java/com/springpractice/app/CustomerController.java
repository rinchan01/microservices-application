package com.springpractice.app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.app.entity.Customer;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId) {
        log.info("get customer by id{}", customerId);
        return customerService.getCustomer(customerId);
    }
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("new customer registration{}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
} 