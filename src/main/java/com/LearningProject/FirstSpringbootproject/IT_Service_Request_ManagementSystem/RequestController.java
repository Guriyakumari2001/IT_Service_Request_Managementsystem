package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;


import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.dou.ObjectModel;
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
    public ResponseEntity<Object> RegisterNewCustomer(@RequestBody RequestModel requestModel) {
        ObjectModel ob1 = new ObjectModel();
        try {
            ob1.message = "Your request has been created sucessfully.";
            ob1.flag = true;
            ob1.requestModel = requestservice.addNewCustomer(requestModel);
            return new ResponseEntity<>(ob1, HttpStatus.OK);
        } catch (Exception e) {
            String getemail = requestModel.getEmail();
            System.out.println(getemail + "This is getting email");
            boolean validEmail = requestValidator.validateEmail(getemail);
            System.out.println(validEmail);


            boolean validatePhoneNumber = requestValidator.validatePhoneNumber(requestModel.getPhoneNumber());
            if (validEmail == false && validatePhoneNumber == false) {
                System.out.println("Email & phoneNumber is invalid");
                ob1.message = "Invalid email & phoneNumber";
            } else if (validEmail == false) {
                System.out.println("Email is invalid");
                ob1.message = "Invalid email address";
            } else if (validatePhoneNumber == false) {
                System.out.println("PhoneNumber is invalid");
                ob1.message = "Invalid PhoneNumber";
            } else {
                System.out.println("Error is happening");
                ob1.message = "Error in raise request";
            }


            ob1.flag = false;
            return new ResponseEntity<>(ob1, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping(path = "/deleteRequest/{id}")
    public ResponseEntity<Object> DeleteRequest(@PathVariable("id") Long id) {
        ObjectModel ob1 = new ObjectModel("The request with this id is deleted ", true, requestservice.DeleteRequest(id));
        try {

            return new ResponseEntity<>(ob1, HttpStatus.OK);
        } catch (Exception e) {
            ob1.message = "id does not exist";
            ob1.flag = false;
            return new ResponseEntity<>(ob1, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping(path = "/getRequest")
    public ResponseEntity<Object> getStudent() {
        try {
            return new ResponseEntity<>(requestservice.getStudent(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error in Get request", HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping(path = "/editRequest")
    public ResponseEntity<Object> EditRequest(@RequestBody RequestModel requestModel) {
        ObjectModel EditModel = new ObjectModel("Request_details has updated successfully", true, requestservice.EditRequest(requestModel));
        try {


            return new ResponseEntity<>(EditModel, HttpStatus.OK);
        } catch (Exception e) {
            EditModel.message = "The id is not present";
            EditModel.flag = false;


            return new ResponseEntity<>(EditModel, HttpStatus.BAD_REQUEST);

        }

    }


}


