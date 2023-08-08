package com.cvbackend.services.impl;

import com.cvbackend.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private static final String EMAIL_RECEIVER = "bohdankovalenkowork@gmail.com";
    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(String subject, String text) {
        SimpleMailMessage simpleMailMessage = buildSimpleMailMessage(subject, text);
        mailSender.send(simpleMailMessage);
    }

    private SimpleMailMessage buildSimpleMailMessage(String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText(text);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setTo(EMAIL_RECEIVER);
        return simpleMailMessage;
    }
}
