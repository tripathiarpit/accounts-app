package com.eazybytes.accounts.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(
        name = "FundTransfer",
        description = "Schema for transferring funds between accounts"
)
public class FundTransferDto {

    @Schema(description = "Sender's account number", example = "9876543210")
    @NotNull(message = "Sender account number is required")
    private Long fromAccountNumber;

    @Schema(description = "Receiver's account number", example = "1234567890")
    @NotNull(message = "Receiver account number is required")
    private Long toAccountNumber;

    @Schema(description = "Amount to transfer", example = "5000.00")
    @NotNull(message = "Transfer amount is required")
    @DecimalMin(value = "1.0", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @Schema(description = "Remarks for the transaction", example = "Rent payment")
    private String remarks;
}
