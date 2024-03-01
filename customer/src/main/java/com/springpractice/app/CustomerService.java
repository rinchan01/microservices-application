package com.springpractice.app;

import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

import com.springpractice.app.entity.Customer;
import com.springpractice.fraud.FraudCheckResponse;
import com.springpractice.fraud.FraudClient;
import com.springpractice.notification.NotificationClient;
import com.springpractice.notification.NotificationResponse;

import lombok.AllArgsConstructor;

//handle requests from the controller
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public Customer getCustomer(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    @SuppressWarnings("null")
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        // throw new UnsupportedOperationException("Not implemented yet");
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        // store the customer in the database
        customerRepository.saveAndFlush(customer);
        // todo: check if email is valid
        // todo: check if email is already taken
        // check if fraudster
        // FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
        // "http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class,
        // customer.getId());
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
        else {
            notificationClient.sendNotifications(customer.getId());
        }
    }
}
