package com.cvbackend.services.impl;

import com.cvbackend.entities.Message;
import com.cvbackend.payload.input.MessageRequest;
import com.cvbackend.repositories.MessageRepository;
import com.cvbackend.services.EmailService;
import com.cvbackend.services.MessageService;
import com.cvbackend.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;
    private final EmailService emailService;
    private final EmailUtils emailUtils;

    @Override
    public void saveInputMessage(MessageRequest messageRequest) {
        Message message = new Message(messageRequest.getSenderName(),
                messageRequest.getSenderEmail(),
                messageRequest.getSubject(),
                messageRequest.getMessageText());
        repository.save(message);
    }

    @Override
    public void sendMessageOnEmail(MessageRequest messageRequest) {
        String emailMessage = emailUtils.generateEmailBody(messageRequest);
        String emailSubject = messageRequest.getSubject();
        emailService.sendEmail(emailSubject, emailMessage);
    }
}
