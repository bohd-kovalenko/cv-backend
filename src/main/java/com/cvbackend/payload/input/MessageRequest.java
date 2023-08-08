package com.cvbackend.payload.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MessageRequest {
    @Size(max = 60)
    private final String senderName;
    @Email
    private final String senderEmail;
    @Size(max = 200)
    private final String subject;
    @Size(max = 10000)
    private final String messageText;

    @JsonCreator
    public MessageRequest(@JsonProperty(value = "sender_name") String senderName,
                          @JsonProperty(value = "sender_email") String senderEmail,
                          @JsonProperty(value = "subject") String subject,
                          @JsonProperty(value = "message_text") String messageText) {
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.messageText = messageText;
    }
}
