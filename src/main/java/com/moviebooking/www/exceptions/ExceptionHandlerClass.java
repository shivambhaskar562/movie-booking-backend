package com.moviebooking.www.exceptions;

import com.moviebooking.www.response.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handelNotFound(ResourceNotFoundException e){
        ResponseStructure responseStructure = new ResponseStructure();
        responseStructure.setStatus("Error");
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(e.getMessage());
        responseStructure.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseStructure<String>> handelAllOtherException(Exception e){
        ResponseStructure responseStructure = new ResponseStructure();
        responseStructure.setStatus("Error");
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(e.getMessage());
        responseStructure.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }
}
