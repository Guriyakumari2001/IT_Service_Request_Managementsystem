package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;
import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.dou.ObjectModel;
import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions.InvalidEmailException;
import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions.InvalidPhoneNumberException;
import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.validators.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController

@Validated
public class RequestController {
    private final RequestService requestservice;

    private ObjectModel objectModel;
    private RequestValidator requestValidator;
    @Autowired
    public RequestController(RequestService requestservice) {
        this.requestservice = requestservice;
    }

    @PostMapping("/raiseRequest")
    public ResponseEntity<Object> raiseRequest(@RequestBody RequestModel requestModel) {
        if (!requestValidator.validateEmail(requestModel.getEmail()) && !requestValidator.validatePhoneNumber(requestModel.getPhoneNumber()))
            throw new InvalidEmailException("Invalid Email & PhoneNumber");
        else if (!requestValidator.validateEmail(requestModel.getEmail()))
            throw new InvalidEmailException("Invalid Email id");
        else if (!requestValidator.validatePhoneNumber(requestModel.getPhoneNumber()))
            throw new InvalidPhoneNumberException("Invalid PhoneNumber");
        else {
            ObjectModel ob1 = new ObjectModel("Your request has been created successfully.", true, requestservice.raiseRequest(requestModel));
            return new ResponseEntity<>(ob1, HttpStatus.OK);
        }
    }
    @DeleteMapping(path = "/deleteRequest/{id}")
    public ResponseEntity<Object> deleteRequest(@PathVariable("id") Long id) {
        ObjectModel ob1 = new ObjectModel("The request with this id is deleted ", true, requestservice.deleteRequest(id));
        System.out.println("This id is deleted");
        return new ResponseEntity<>(ob1, HttpStatus.OK);
    }

    @GetMapping(path = "/getRequest")
    public ResponseEntity<Object> getStudent() {
        return new ResponseEntity<>(requestservice.getStudent(), HttpStatus.OK);
    }

    @PutMapping(path = "/editRequest")
    public ResponseEntity<Object> editRequest(@RequestBody RequestModel requestModel) {
        ObjectModel EditModel = new ObjectModel("Request_details has updated successfully", true, requestservice.editRequest(requestModel));
        return new ResponseEntity<>(EditModel, HttpStatus.OK);
    }


}


