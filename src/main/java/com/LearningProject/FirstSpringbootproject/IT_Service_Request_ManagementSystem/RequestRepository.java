package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RequestRepository extends JpaRepository<RequestModel, Long> {


    @Override
    Optional<RequestModel> findById(Long id);
}
