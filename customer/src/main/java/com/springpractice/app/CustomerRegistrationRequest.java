package com.springpractice.app;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}