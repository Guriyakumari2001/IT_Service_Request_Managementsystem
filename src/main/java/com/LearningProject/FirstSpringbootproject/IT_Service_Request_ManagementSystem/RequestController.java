package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
@RestController


public class RequestController
{


    private final RequestService requestservice;
    @Autowired
    public  RequestController(RequestService requestservice) {
        this.requestservice = requestservice;
    }
     @PostMapping("/raiseRequest")
     public void RegisterNewCustomer(@Valid @RequestBody  RequestModel requestModel){
       requestservice.addNewCustomer(requestModel);
     }
    @GetMapping(path="/getRequest")
    public List<RequestModel>getStudent()
    {
        System.out.println("The object is calling the getstudent method");
        return requestservice.getStudent();
    }


}


