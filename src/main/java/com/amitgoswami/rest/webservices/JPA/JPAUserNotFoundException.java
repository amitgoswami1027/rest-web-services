package com.amitgoswami.rest.webservices.JPA;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JPAUserNotFoundException extends RuntimeException
{
    public JPAUserNotFoundException(String message)
    {
        super(message);
    }
}
