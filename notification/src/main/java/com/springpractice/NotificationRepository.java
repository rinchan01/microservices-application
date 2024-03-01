package com.springpractice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springpractice.entity.Notification;

public interface NotificationRepository extends JpaRepository <Notification, Integer> {

} 