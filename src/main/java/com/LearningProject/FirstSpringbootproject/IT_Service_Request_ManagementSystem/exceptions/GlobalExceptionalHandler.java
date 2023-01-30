package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionalHandler {
    //handle specific exception
    //handle global exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> HandleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){

        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(APIException.class)
    public ResponseEntity<?> HandleAPIException(ResourceNotFoundException exception, WebRequest request){

        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
