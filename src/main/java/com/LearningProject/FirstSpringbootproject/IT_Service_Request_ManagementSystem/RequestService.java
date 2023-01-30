package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions.ErrorDetails;
import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions.ResourceNotFoundException;
import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.validators.RequestValidator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RequestService {
    private RequestRepository requestRepository;
    private RequestValidator requestValidator;



    //Todo Change the name of the function
    public RequestModel addNewCustomer(RequestModel requestModel) {
        if (validateRequest(requestModel)) {
            requestModel.setStatus(Status.OPEN);
            RequestModel savedRequestModel = requestRepository.save(requestModel);
            return savedRequestModel;
        } else {
            throw new IllegalArgumentException("Input Not Valid");
        }
    }

    public void AddExistCoustomer(RequestModel requestModel) {
        requestModel.setStatus(Status.CLOSED);
        requestRepository.save(requestModel);
    }

    @Transactional
    public RequestModel EditRequest(RequestModel r1) {
        Long fetchId = r1.getId();
        String description = r1.getRequest_details();
        System.out.println(description);
        boolean exist = requestRepository.existsById(fetchId);
        RequestModel r2 = requestRepository.findById(fetchId)
                .orElseThrow(() -> new ResourceNotFoundException("customer with id " + " " + fetchId  + " does not exist"));
            if (description != null && description.length() > 0 && !Objects.equals(description, r2.getRequest_details())) {
                r2.setRequest_details(description);
                System.out.println(r2.getRequest_details());
            }
            return r2;

    }

    public RequestModel DeleteRequest(Long id1) {
        boolean exists = requestRepository.existsById(id1);
        Optional<RequestModel> deleteModelbyId = Optional.ofNullable(requestRepository.findById(id1).
                orElseThrow(() -> new ResourceNotFoundException("Request with id " + id1 + " does not exist in db")));
        requestRepository.deleteById(id1);
        return deleteModelbyId.get();
    }


    public List<RequestModel> getStudent() {
        return requestRepository.findAll();
    }
    public boolean validateRequest(RequestModel requestModel) {
        return requestValidator.validateEmail(requestModel.getEmail()) && requestValidator.validatePhoneNumber(requestModel.getPhoneNumber());
    }

}






