package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
