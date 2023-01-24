package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import java.util.List;
@RestController
@Service

@Validated
@Email

public class RequestService {
private RequestService requestService;
    private RequestRepository requestRepository;
@Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

public void addNewCustomer(RequestModel requestModel)
{
    System.out.println(requestModel);
}


        public List<RequestModel> getStudent()
        {
            System.out.println("This student model is calling and returning something");
           return requestRepository.findAll();
        }
    }





