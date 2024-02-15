package com.springpractice.app;

import org.springframework.stereotype.Service;

import com.springpractice.app.entity.Customer;

//handle requests from the controller
@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        //throw new UnsupportedOperationException("Not implemented yet");
        Customer customer = Customer.builder().
            firstName(customerRequest.firstName()).
            lastName(customerRequest.lastName()).
            email(customerRequest.email()).
            build();
        //todo: check if email is valid
        //todo: check if email is already taken

        //store the customer in the database
       customerRepository.save(customer);
        

    }
}
