package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Order
public class Requestconfig {
    @Bean
    @Enumerated(EnumType.STRING)
    CommandLineRunner commandLineRunner(RequestRepository requestRepository) {
        return args -> {
            RequestModel m1 = new RequestModel(
                    "aruhi",
                    "guriyakuamrigupta661@gmail.com",
                    "9065060669",
                    "I am not able to raise the claim",
                    Status.OPEN);
            RequestModel m2 = new RequestModel(
                    "ayus",
                    "Manishkumar123@gmail.com",
                    "9087654341",
                    "I am not able to fill",
                    Status.OPEN);

            ArrayList<RequestModel> modelsList = new ArrayList<>();
            modelsList.add(m1);
            modelsList.add(m2);
            //This is used to save the given data into database
            requestRepository.saveAll(
                    modelsList
            );

        };

    }
}

