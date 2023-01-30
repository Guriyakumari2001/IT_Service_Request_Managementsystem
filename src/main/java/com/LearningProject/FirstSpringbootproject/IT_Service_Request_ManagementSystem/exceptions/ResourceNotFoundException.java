package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   private static final long serialVersionUID = 1L;
    public ResourceNotFoundException (String message) {
        super(message);
    }
}



