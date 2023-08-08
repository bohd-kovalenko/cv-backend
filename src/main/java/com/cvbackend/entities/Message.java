package com.cvbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "sender_name", nullable = false)
    private String senderName;
    @Column(name = "sender_email", nullable = false)
    private String senderEmail;
    @Column(name = "subject", nullable = false)
    private String subject;
    @Column(name = "message_text", nullable = false)
    private String messageText;

    public Message(String senderName, String senderEmail, String subject, String messageText) {
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.messageText = messageText;
    }
}
