package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(String objectName){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ivanlatysheff@gmail.com");
        message.setTo("ivanlatyshev024@gmail.com");
        message.setSubject("New Object");
        message.setText("A new object has been created");
        try {
            mailSender.send(message);
            System.out.println("Email sent successfully");
        } catch (MailException e) {
            System.out.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
