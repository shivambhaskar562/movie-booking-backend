package com.moviebooking.www.exceptions;

import com.moviebooking.www.response.ResponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseAPI<String>> handelNotFound(ResourceNotFoundException e){
        ResponseAPI responseAPI = new ResponseAPI();
        responseAPI.setStatus("Error");
        responseAPI.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseAPI.setMessage(e.getMessage());
        responseAPI.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(responseAPI, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseAPI<String>> handelAllOtherException(Exception e){
        ResponseAPI responseAPI = new ResponseAPI();
        responseAPI.setStatus("Error");
        responseAPI.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseAPI.setMessage(e.getMessage());
        responseAPI.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(responseAPI, HttpStatus.NOT_FOUND);
    }
}
