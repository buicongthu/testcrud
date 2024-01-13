package com.example.testcrud.exception;

public class NotfoundException extends RuntimeException{
    public NotfoundException (String mess){
        super(mess);
    }
}
