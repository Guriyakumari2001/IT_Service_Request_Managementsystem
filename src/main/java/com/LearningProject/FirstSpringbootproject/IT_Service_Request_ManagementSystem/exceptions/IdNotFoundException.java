package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;

public class IdNotFoundException extends IllegalArgumentException {

    private String message;

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    public IdNotFoundException(String message) {
        this.message = message;
    }
}
