package com.digitalInovationOne.personapi.controller;

import com.digitalInovationOne.personapi.dto.request.EmailDTO;
import com.digitalInovationOne.personapi.dto.response.MessageResponseDTO;
import com.digitalInovationOne.personapi.exception.EmailNotFoundException;
import com.digitalInovationOne.personapi.exception.PersonNotFoundException;
import com.digitalInovationOne.personapi.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/email")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmailController {

    private EmailService emailService;

    @PostMapping("/person/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEmail(@PathVariable Long userId, @RequestBody EmailDTO emailDTO) throws PersonNotFoundException {

        return emailService.createEmail(userId, emailDTO);
    }

    @GetMapping
    public List<EmailDTO> listAllEmails() {
        System.out.println("Aqui");
        return emailService.listAllEmails();
    }

    @GetMapping("/{emailId}")
    public EmailDTO findById(@PathVariable long emailId) throws EmailNotFoundException {
        return emailService.findById(emailId);
    }

    @PutMapping("/{emailId}/person/{userId}")
    public MessageResponseDTO updateById(@PathVariable Long userId, @PathVariable Long emailId, @RequestBody @Valid EmailDTO emailDTO) throws EmailNotFoundException, PersonNotFoundException {
        return emailService.updateEmailById(userId, emailId, emailDTO);
    }

    @DeleteMapping("/{emailId}/person/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long emailId, @PathVariable long userId) throws EmailNotFoundException, PersonNotFoundException {
        emailService.deleteEmail(emailId, userId);
    }
}
