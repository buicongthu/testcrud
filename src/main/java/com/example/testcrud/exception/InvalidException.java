package com.example.testcrud.exception;

public class InvalidException extends RuntimeException{
        public InvalidException (String mess){
            super(mess);
        }
}
