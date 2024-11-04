package com.notification_service.notification_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void handleNotification(String message) {
        try {
            System.out.println("Notification received: " + message);
            sendEmailNotification(message);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'envoi de la notification: " + e.getMessage());
        }
    }
    
    // Méthode pour envoyer un email (exemple)
    public void sendEmailNotification(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("destinataire@example.com");
        mailMessage.setSubject("Nouvelle notification");
        mailMessage.setText(message);
        
        mailSender.send(mailMessage);
    }
}

