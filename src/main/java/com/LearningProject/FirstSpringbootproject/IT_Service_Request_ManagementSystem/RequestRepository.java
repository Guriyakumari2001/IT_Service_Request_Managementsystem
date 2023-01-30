package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface RequestRepository extends JpaRepository<RequestModel, Long> {
    RequestModel findFirstBy();


    @Override
    Optional<RequestModel> findById(Long id);


}
