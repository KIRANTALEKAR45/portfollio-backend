package com.kiran.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendNotification(String name, String email, String message) {

        SimpleMailMessage mail = new SimpleMailMessage();

        // 🔥 IMPORTANT: Replace with YOUR Gmail
        mail.setTo("kirantalekar999@gmail.com");

        // Sender (same as application.properties username)
        mail.setFrom("kirantalekar999@gmail.com");

        mail.setSubject("🚀 New Contact Form Message - Portfolio");

        mail.setText(
                "You received a new message from your portfolio:\n\n" +
                "----------------------------------\n" +
                "Name   : " + name + "\n" +
                "Email  : " + email + "\n" +
                "Message: " + message + "\n" +
                "----------------------------------"
        );

        mailSender.send(mail);
    }
}
