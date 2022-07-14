package com.example.apiwithtesting.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(Exception exception){
        return new ResponseEntity<>(
                new EntityErrorResponse().builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(exception.getMessage())
                        .timeStamp(System.currentTimeMillis())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(EntityNotFoundException entityNotFoundException){
        return new ResponseEntity<>(
                new EntityErrorResponse().builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(entityNotFoundException.getMessage())
                        .timeStamp(System.currentTimeMillis())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}
