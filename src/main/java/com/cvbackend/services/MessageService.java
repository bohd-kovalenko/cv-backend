package com.cvbackend.services;

import com.cvbackend.payload.input.MessageRequest;

public interface MessageService {
    void saveInputMessage(MessageRequest messageRequest);

    void sendMessageOnEmail(MessageRequest messageRequest);
}
