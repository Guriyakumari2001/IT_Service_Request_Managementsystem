package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> HandleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        System.out.println(" Handling Exception " +  exception.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        System.out.println(request.getDescription(false));
        System.out.println(errorDetails);
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<?> HandleInvalidEmailException(InvalidEmailException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);

    }@ExceptionHandler(InvalidPhoneNumberException.class)
    public ResponseEntity<?> HandleInvalidPhoneNumberException(InvalidPhoneNumberException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);

    }

}
