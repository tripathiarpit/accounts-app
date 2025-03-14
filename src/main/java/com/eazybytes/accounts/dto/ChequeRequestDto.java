package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "ChequeRequest",
        description = "Schema for cheque book requests"
)
public class ChequeRequestDto {

    @Schema(description = "Account number", example = "9876543210")
    @NotNull(message = "Account number is required")
    private Long accountNumber;

    @Schema(description = "Number of cheque leaves requested", example = "25")
    @Min(value = 10, message = "Minimum 10 leaves should be requested")
    @Max(value = 50, message = "Maximum 50 leaves can be requested")
    private Integer numberOfLeaves;
}
