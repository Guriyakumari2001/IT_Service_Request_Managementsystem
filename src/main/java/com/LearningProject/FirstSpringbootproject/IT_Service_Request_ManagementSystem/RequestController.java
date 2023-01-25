package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController

@Validated
public class RequestController {


    private final RequestService requestservice;

    @Autowired
    public RequestController(RequestService requestservice) {
        this.requestservice = requestservice;
    }

    @PostMapping("/raiseRequest")
    public void RegisterNewCustomer(@RequestBody RequestModel requestModel) {
        requestservice.addNewCustomer(requestModel);
    }

    @DeleteMapping(path = "/deleteRequest/{id}")
    public void DeleteCustomer(@PathVariable("id") Long id) {
        System.out.println("Delete the message has called");
        requestservice.DeleteCustomername(id);
    }

    @GetMapping(path = "/getRequest")
    public List<RequestModel> getStudent() {
        System.out.println("The object is calling the getstudent method");
        return requestservice.getStudent();
    }
    @PutMapping(path="/editRequest")
    public void updateCustomer(@RequestBody RequestModel requestModel)
    {requestservice.updatecustomer(requestModel);
    }


}


