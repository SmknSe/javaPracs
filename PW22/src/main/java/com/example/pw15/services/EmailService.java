package com.example.pw15.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.send_to}")
    String to;

    @Async
    public void sendEmail(String text){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("semeykin2003@mail.ru");
            mailMessage.setTo(to);
            mailMessage.setSubject("Logging on creation and updation");
            mailMessage.setText(text);
            javaMailSender.send(mailMessage);
    }
}
