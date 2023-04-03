package com.rating.ratingservices.exceptions;

import org.springframework.http.ResponseEntity;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message){
        super(message);
    }
   public ResourceNotFound(){
        super("Resource Not Found!");
    }
}
