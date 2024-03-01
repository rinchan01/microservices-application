package com.springpractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.notification.NotificationResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/notifications")
public record NotificationController (NotificationService notificationService) {
    
    @GetMapping(path = "/{customerId}")
    public NotificationResponse sendNotification(Integer customerId) {
        log.info("Sending notification to customer {}", customerId);
        return notificationService.sendNotification(customerId);
    }
}
