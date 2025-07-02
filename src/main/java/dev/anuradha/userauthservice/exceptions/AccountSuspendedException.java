package dev.anuradha.userauthservice.exceptions;

public class AccountSuspendedException extends RuntimeException{
    public  AccountSuspendedException(String message){
        super(message);
    }
}
