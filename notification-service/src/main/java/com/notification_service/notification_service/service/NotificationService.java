package com.notification_service.notification_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void handleNotification(String message) {
        // Logique pour traiter le message et envoyer la notification
        System.out.println("Notification received: " + message);
        
        // Par exemple : envoi d'email ou SMS
        // sendEmailNotification(message);
    }
    
    // Méthode pour envoyer un email (exemple)
    public void sendEmailNotification(String message) {
        // Logique d'envoi d'email
    }
}

