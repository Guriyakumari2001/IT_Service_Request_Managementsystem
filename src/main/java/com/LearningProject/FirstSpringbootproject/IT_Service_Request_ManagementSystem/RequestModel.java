package com.LearningProject.FirstSpringbootproject.IT_Service_Request_ManagementSystem;
import org.springframework.core.annotation.Order;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity

@Table
@NoArgsConstructor
@AllArgsConstructor

public class RequestModel {

    @Id
    @SequenceGenerator(
            name = "customer_name",
            sequenceName = "customer_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "customer_name"
    )


    @NotNull
    private @Getter
    @Setter Long id;
    @NotNull(message = "Customer_name cannot be missing or empty")
    @NotBlank
    @NotEmpty
    @Size(min = 2, message = "customer_name must containing greater than 2 character")
    private @Getter
    @Setter String Customer_name;


    private @Getter
    @Setter String Email;
    @NotNull
    @Size(min = 10, max = 10)

    private @Getter
    @Setter String PhoneNumber;
    @NotNull
    private @Getter
    @Setter String Request_details;
    @Enumerated(EnumType.STRING)
    private @Getter
    @Setter Status status;
}






