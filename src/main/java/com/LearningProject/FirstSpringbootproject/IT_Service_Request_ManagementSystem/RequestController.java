package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;


import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.dou.ObjectModel;
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


    @Autowired
    public RequestController(RequestService requestservice) {
        this.requestservice = requestservice;
    }

    @PostMapping("/raiseRequest")
    public ResponseEntity<Object> RegisterNewCustomer(@RequestBody RequestModel requestModel) {
        ObjectModel ob1 = new ObjectModel();
        try {

            ob1.message = "Raise request is created";
            ob1.flag = true;
            ob1.requestModel = requestservice.addNewCustomer(requestModel);
            return new ResponseEntity<>(ob1, HttpStatus.OK);

        } catch (Exception e) {

            ob1.message = "Error in Raise request";
            ob1.flag = false;

            return new ResponseEntity<>(ob1, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/deleteRequest/{id}")
    public ResponseEntity<Object> DeleteRequest(@PathVariable("id") Long id)
    {
        ObjectModel ob1 = new ObjectModel();
        try {
            ob1.message = "The customer_name of this id has deleted successfully";
            ob1.flag = true;
            ob1.requestModel = requestservice.DeleteRequest(id);
            return new ResponseEntity<>(ob1, HttpStatus.OK);
        } catch (Exception e) {
            ob1.message="id does not exist";
            ob1.flag=false;
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
        ObjectModel EditModel=new ObjectModel();
        try {
            EditModel.message="Request_details has updated successfully";
            EditModel.flag=true;
            EditModel.requestModel=requestservice.EditRequest(requestModel);

            return new ResponseEntity<>(EditModel, HttpStatus.OK);
        } catch (Exception e) {
            EditModel.message="The id is not present";
            EditModel.flag=false;


            return new ResponseEntity<>(EditModel, HttpStatus.BAD_REQUEST);

        }

    }



}


