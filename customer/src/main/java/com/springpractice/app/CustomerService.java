package com.springpractice.app;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springpractice.app.entity.Customer;

//handle requests from the controller
@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    @SuppressWarnings("null")
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        //throw new UnsupportedOperationException("Not implemented yet");
        Customer customer = Customer.builder().
            firstName(customerRequest.firstName()).
            lastName(customerRequest.lastName()).
            email(customerRequest.email()).
            build();
        //todo: check if email is valid
        //todo: check if email is already taken
        //todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
            "http:localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Customer is a fraudster");
        }
        //store the customer in the database
       customerRepository.save(customer);
        // todo: send notification 


    }
}
