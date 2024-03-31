package com.springpractice.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification", url = "http://notification.default.svc.cluster.local")
public interface NotificationClient {
        @PostMapping("/api/v1/notifications")
        void sendNotification(NotificationRequest request);
} 
