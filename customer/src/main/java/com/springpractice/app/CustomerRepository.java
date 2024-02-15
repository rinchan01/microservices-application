package com.springpractice.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springpractice.app.entity.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Integer>{
    
}
