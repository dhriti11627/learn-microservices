package com.dhriti.hotel.HotelService.exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message){
        super(message);
    }

  public  ResourceNotFound(){
        super("Resource Not Found");
    }
}
