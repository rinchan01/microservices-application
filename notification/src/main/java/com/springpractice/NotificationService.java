package com.springpractice;

import org.springframework.stereotype.Service;

import com.springpractice.entity.Notification;
import com.springpractice.notification.NotificationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService{
    private final NotificationRepository notificationRepository;

    @SuppressWarnings("null")
    public void sendNotification(NotificationRequest request) {
        notificationRepository.saveAndFlush(
                Notification.builder()
                    .customerId(request.customerId())
                    .message(request.message())
                    .build()
                );

    }
}
