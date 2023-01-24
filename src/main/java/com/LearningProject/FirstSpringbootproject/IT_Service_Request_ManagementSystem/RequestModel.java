package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.core.annotation.Order;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;





    @Entity
    @Table
    @Order
    public class RequestModel {

        @Id
        @SequenceGenerator(
                name = "customer_name",
                sequenceName = "customer_name",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "customer_name"
        )
        @NotNull
        private long id;
        @NotNull(message = "Customer_name cannot be missing or empty")
        @NotBlank
        @NotEmpty
        @Size(min = 2, message = "customer_name must containing greater than 2 character")
        private String Customer_name;
        @Email
        @Valid

        private String Email;
        @NotNull
        @Size(min = 10, max = 10)

        private String Phoneno;
        @NotNull
        private String Request_details;
     @Enumerated(EnumType.STRING)
        private Status status;

        public RequestModel() {
        }
        public RequestModel(long id, String customer_name, String email, String phoneno, String request_details, String status) {
        }

        public RequestModel(long id, String customer_name, String email, String phoneno, String request_details, Status status) {
            this.id = id;
            Customer_name = customer_name;
            Email = email;
            Phoneno = phoneno;
            Request_details = request_details;
            this.status = status;
        }

        public RequestModel(String customer_name, String email, String phoneno, String request_details, Status status) {
            Customer_name = customer_name;
            Email = email;
            Phoneno = phoneno;
            Request_details = request_details;
            this.status = status;
        }



        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCustomer_name() {
            return Customer_name;
        }

        public void setCustomer_name(String customer_name) {
            Customer_name = customer_name;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPhoneno() {
            return Phoneno;
        }

        public void setPhoneno(String phoneno) {
            Phoneno = phoneno;
        }

        public String getRequest_details() {
            return Request_details;
        }

        public void setRequest_details(String request_details) {
            Request_details = request_details;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "RequestModel{" +
                    "id=" + id +
                    ", Customer_name='" + Customer_name + '\'' +
                    ", Email='" + Email + '\'' +
                    ", Phoneno='" + Phoneno + '\'' +
                    ", Request_details='" + Request_details + '\'' +
                    ", Status=" + status +
                    '}';
        }
    }





