package com.springpractice;

import org.springframework.stereotype.Service;

import com.springpractice.entity.Notification;
import com.springpractice.notification.NotificationResponse;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    @SuppressWarnings("null")
    public NotificationResponse sendNotification(Integer customerId) {
        notificationRepository.saveAndFlush(
                Notification.builder()
                    .customerId(null)
                    .build()
                );
        return new NotificationResponse("Notification sent");

    }
}
