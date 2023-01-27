package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController

@Validated
public class RequestController {


    private final RequestService requestservice;

    @Autowired
    public RequestController(RequestService requestservice) {
        this.requestservice = requestservice;
    }

    @PostMapping("/raiseRequest")
    public ResponseEntity<Object> RegisterNewCustomer(@RequestBody RequestModel requestModel) {
        try {
            return new ResponseEntity<>(requestservice.addNewCustomer(requestModel),HttpStatus.OK) ;

        } catch (Exception e) {
            return new ResponseEntity<>("Error in Raise request", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/deleteRequest/{id}")
    public ResponseEntity<Object> DeleteRequest(@PathVariable("id") Long id) {
        try {
           return new ResponseEntity<>(requestservice.DeleteRequest(id),HttpStatus.OK) ;
        }
       catch(Exception e){
            return new ResponseEntity<>("id does not exist",HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping(path = "/getRequest")
    public ResponseEntity<Object> getStudent() {
        try{
            return new ResponseEntity<>(requestservice.getStudent(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error in Get request", HttpStatus.BAD_REQUEST);

        }

    }
    @PutMapping(path="/editRequest")
    public ResponseEntity<Object> EditRequest(@RequestBody RequestModel requestModel)
    {
        try{
            return new ResponseEntity<>(requestservice.EditRequest(requestModel),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("The id is not present", HttpStatus.BAD_REQUEST);

    }

    }


}


