package com.springpractice.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("notification")
public interface NotificationClient {
        @GetMapping(path = "api/v1/notifications/{customerId}")
        NotificationResponse sendNotifications(@PathVariable("customerId") Integer customerId);
} 
