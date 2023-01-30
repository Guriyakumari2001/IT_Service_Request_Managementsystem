package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions;




import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails  {
    private  Date timestamp;
    private String message;
    private String details;


}
