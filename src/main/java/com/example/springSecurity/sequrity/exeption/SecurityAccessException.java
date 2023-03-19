package com.example.springSecurity.sequrity.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * эксепш - класс
 * {@link
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class SecurityAccessException extends RuntimeException{

    public SecurityAccessException() {
    }
}
