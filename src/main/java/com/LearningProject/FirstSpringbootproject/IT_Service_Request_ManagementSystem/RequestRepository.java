package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestModel,String>
{


}
