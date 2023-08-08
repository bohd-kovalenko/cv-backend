package com.cvbackend.utils.impl;

import com.cvbackend.payload.input.MessageRequest;
import com.cvbackend.utils.EmailUtils;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilsImpl implements EmailUtils {
    @Override
    public String generateEmailBody(MessageRequest messageRequest) {
        return String
                .format("%s messaged you! \nMessage text: %s | Feedback email: %s",
                        messageRequest.getSenderName(),
                        messageRequest.getMessageText(),
                        messageRequest.getSenderEmail());
    }
}
