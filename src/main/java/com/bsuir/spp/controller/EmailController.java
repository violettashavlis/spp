package com.bsuir.spp.controller;

import com.bsuir.spp.model.Email;
import com.bsuir.spp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    @CrossOrigin
    public ResponseEntity sendEmail(@RequestBody Email email){
        emailService.sendSimpleMessage(email);
        return ResponseEntity.ok().build();
    }
}
