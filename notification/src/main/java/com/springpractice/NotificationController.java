package com.springpractice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.notification.NotificationRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request) {
        log.info("New notification request... {}", request);
        notificationService.sendNotification(request);
    }
    
    // @GetMapping(path = "/{customerId}")
    // public NotificationResponse sendNotification(Integer customerId) {
    //     log.info("Sending notification to customer {}", customerId);
    //     return notificationService.sendNotification(customerId);
    // }
}
