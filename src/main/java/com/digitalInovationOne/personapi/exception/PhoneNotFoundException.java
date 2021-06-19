package com.digitalInovationOne.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PhoneNotFoundException extends Exception {
    public PhoneNotFoundException(long phoneId) {
        super("Phone not found with ID " + phoneId);
    }
}
