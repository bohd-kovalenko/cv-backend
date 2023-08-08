package com.cvbackend.utils;

import com.cvbackend.payload.input.MessageRequest;

public interface EmailUtils {
    String generateEmailBody(MessageRequest messageRequest);
}
