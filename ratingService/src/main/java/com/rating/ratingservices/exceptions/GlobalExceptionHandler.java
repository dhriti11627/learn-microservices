package com.rating.ratingservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFound ex){
        String message = ex.getMessage();
        Map<String , Object> m = new HashMap<>();
        m.put("message",message);
        m.put("success",true);
        m.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(m,HttpStatus.NOT_FOUND);
    }
}
