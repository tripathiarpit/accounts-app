package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(
        name = "BillPayment",
        description = "Schema for bill payments like electricity, phone, etc."
)
public class BillPaymentDto {

    @Schema(description = "Customer account number", example = "9876543210")
    @NotNull(message = "Customer account number is required")
    private Long accountNumber;

    @Schema(description = "Biller name", example = "Electricity Board")
    @NotEmpty(message = "Biller name is required")
    private String billerName;

    @Schema(description = "Amount to pay", example = "1200.00")
    @NotNull(message = "Payment amount is required")
    @DecimalMin(value = "1.0", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @Schema(description = "Bill reference number", example = "EB12345678")
    private String billReference;
}
