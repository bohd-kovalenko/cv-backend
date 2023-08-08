package com.cvbackend.controllers;

import com.cvbackend.payload.input.MessageRequest;
import com.cvbackend.services.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Void> handleInputMessage(@Valid @RequestBody MessageRequest messageRequest) {
        messageService.saveInputMessage(messageRequest);
        messageService.sendMessageOnEmail(messageRequest);
        return ResponseEntity.ok().build();
    }
}
