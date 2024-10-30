package com.notification_service.notification_service.model;

import lombok.Data;

@Data
public class Notification {
    private String recipient;
    private String subject;
    private String content;
    private String type; // Ex: EMAIL, SMS
}
