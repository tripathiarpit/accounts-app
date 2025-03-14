package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "Payee",
        description = "Schema for managing payee details"
)
public class PayeeDto {

    @Schema(description = "Payee's name", example = "John Smith")
    @NotEmpty(message = "Payee name cannot be empty")
    private String name;

    @Schema(description = "Payee's account number", example = "1234567890")
    @NotNull(message = "Payee account number is required")
    private Long accountNumber;

    @Schema(description = "Payee's IFSC code", example = "EAZY0123456")
    @NotEmpty(message = "IFSC code is required")
    private String ifscCode;
}

