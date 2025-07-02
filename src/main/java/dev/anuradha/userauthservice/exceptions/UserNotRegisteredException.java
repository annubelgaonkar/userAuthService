package dev.anuradha.userauthservice.exceptions;

public class UserNotRegisteredException extends RuntimeException{
    public UserNotRegisteredException(String message){
        super(message);
    }
}
