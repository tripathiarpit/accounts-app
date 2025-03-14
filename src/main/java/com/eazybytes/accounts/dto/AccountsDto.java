package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(description = "Unique identifier for the account", example = "9876543210")
    private Long accountNumber;

    @Schema(description = "Type of the account", example = "SAVINGS")
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;

    @Schema(description = "Current balance of the account", example = "25000.75")
    @NotNull(message = "Account balance cannot be null")
    private BigDecimal balance;

    @Schema(description = "IFSC Code of the account", example = "EAZY0123456")
    private String ifscCode;
}
