package com.notification_service.notification_service.controller;

import com.notification_service.notification_service.model.Notification;
import com.notification_service.notification_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendNotification(@RequestBody Notification notification) {
        emailService.sendEmail(notification);
        return "Notification sent to " + notification.getRecipient();
    }
}
