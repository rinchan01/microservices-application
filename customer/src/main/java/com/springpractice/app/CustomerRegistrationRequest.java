package com.springpractice.app;

// CustomerRegistrationRequest is a record class that contains the customer's first name, last name, and email
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}