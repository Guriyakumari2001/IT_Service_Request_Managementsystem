package com.LearningProject.FirstSpringbootproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class FirstSpringbootprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringbootprojectApplication.class, args);
		System.out.println("This appication is running");
	}

}
