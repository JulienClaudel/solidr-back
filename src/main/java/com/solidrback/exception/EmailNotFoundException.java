package com.solidrback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exception for the existence of the email
@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class EmailNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public EmailNotFoundException( String message ) {
        super( message );
    }
}
