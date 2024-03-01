package com.springpractice.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springpractice.app.entity.Customer;

// JpaRepository is a JPA specific interface that provides methods for performing CRUD operations on the entity
// CustomerRepository is an interface that extends JpaRepository and provides methods for CRUD operations
public interface CustomerRepository extends JpaRepository <Customer, Integer>{
    
}
