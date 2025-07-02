package dev.anuradha.userauthservice.controllers;

import dev.anuradha.userauthservice.exceptions.PasswordMismatchException;
import dev.anuradha.userauthservice.exceptions.UserAlreadySignedException;
import dev.anuradha.userauthservice.exceptions.UserNotRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvisor {

    @ExceptionHandler({PasswordMismatchException.class,
            UserNotRegisteredException.class,
            UserAlreadySignedException.class})
    public ResponseEntity<String> handleExceptions(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
