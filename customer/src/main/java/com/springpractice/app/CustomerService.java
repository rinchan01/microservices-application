package com.springpractice.app;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springpractice.app.entity.Customer;

import lombok.AllArgsConstructor;

//handle requests from the controller
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @SuppressWarnings("null")
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        // throw new UnsupportedOperationException("Not implemented yet");
        Customer customer = Customer.builder().firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName()).email(customerRequest.email()).build();
        // store the customer in the database
        customerRepository.saveAndFlush(customer);
        // todo: check if email is valid
        // todo: check if email is already taken
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Customer is a fraudster");
        }

        // todo: send notification

    }
}
