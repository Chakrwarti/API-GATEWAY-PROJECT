package com.lcwd.hotel.service.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found Exception");
    }

    public ResourceNotFoundException(String str){
        super(str);
    }
}
