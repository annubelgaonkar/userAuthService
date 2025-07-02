package dev.anuradha.userauthservice.exceptions;

public class UserAlreadySignedException extends RuntimeException{
    public UserAlreadySignedException(String message){
        super(message);
    }
}
