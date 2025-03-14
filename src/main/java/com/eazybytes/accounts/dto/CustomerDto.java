package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(description = "Unique identifier of the customer", example = "123456")
    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;

    @Schema(description = "Name of the customer", example = "John Doe")
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 3, max = 50, message = "The length of the customer name should be between 3 and 50 characters")
    private String name;

    @Schema(description = "Email address of the customer", example = "john.doe@example.com")
    @NotEmpty(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be a valid format")
    private String email;

    @Schema(description = "Mobile Number of the customer", example = "9876543210")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Date of birth of the customer", example = "1990-05-15")
    @Past(message = "Date of birth must be a past date")
    private LocalDate dateOfBirth;

    @Schema(description = "Address of the customer")
    private AddressDto address;
}
