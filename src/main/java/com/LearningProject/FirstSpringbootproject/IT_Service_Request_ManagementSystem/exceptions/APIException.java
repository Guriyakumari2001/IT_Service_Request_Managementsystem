package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;

public class APIException extends RuntimeException {
    public APIException(String message){
        super(message);


    }
    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }
}
