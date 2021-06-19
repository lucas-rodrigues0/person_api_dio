package com.digitalInovationOne.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmailNotFoundException extends Exception {
    public EmailNotFoundException(long emailId) {
        super("Email not found with ID " + emailId);
    }
}
