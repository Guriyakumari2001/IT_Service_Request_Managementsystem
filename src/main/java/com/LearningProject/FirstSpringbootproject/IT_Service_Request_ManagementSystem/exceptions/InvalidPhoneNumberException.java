package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;

public class InvalidPhoneNumberException extends RuntimeException{
    public InvalidPhoneNumberException(String message){
        super(message);
    }
}
