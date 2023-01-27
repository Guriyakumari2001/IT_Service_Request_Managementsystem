package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.exceptions.IdNotFoundException;
import com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem.validators.RequestValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class RequestService {
    private RequestRepository requestRepository;
    private RequestValidator requestValidator;

    @Autowired
    public RequestService(RequestRepository requestRepository, RequestValidator requestValidator) {
        this.requestRepository = requestRepository;
        this.requestValidator = requestValidator;


    }

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
                .orElseThrow(() -> new RuntimeException("customer with fetchid" + fetchId + "doesnotExist"));
        if (!exist) {
            System.out.println("This id does not exist");
        } else {
            System.out.println("this id is exist and we need to change");

            if (description != null && description.length() > 0 && !Objects.equals(description, r2.getRequest_details())) {
                System.out.println("Now this is updating");
                r2.setRequest_details(description);
                System.out.println(r2.getRequest_details());
            } else {
                System.out.println("description has not changed");
            }
        }

        return r2;


    }

    public RequestModel DeleteRequest(Long id1) {


        boolean exists = requestRepository.existsById(id1);
        Optional<RequestModel> deleteModelbyId = requestRepository.findById(id1);
        if (!exists) {

            throw new IdNotFoundException("Customer with id " + id1 + "does not exist");
        } else {

            System.out.println("Email exist and we can delete");

            requestRepository.deleteById(id1);

        }
        return deleteModelbyId.get();

    }


    public List<RequestModel> getStudent() {
        return requestRepository.findAll();
    }

    public boolean validateRequest(RequestModel requestModel) {
        return requestValidator.validateEmail(requestModel.getEmail()) && requestValidator.validatePhoneNumber(requestModel.getPhoneNumber());
    }

}






