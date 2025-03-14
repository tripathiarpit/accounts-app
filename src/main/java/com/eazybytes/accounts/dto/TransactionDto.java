package com.eazybytes.accounts.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(
        name = "Transaction",
        description = "Schema to hold transaction details"
)
public class TransactionDto {

    @Schema(description = "Transaction ID", example = "TXN123456")
    private String transactionId;

    @Schema(description = "Transaction type", example = "DEBIT")
    private String transactionType;

    @Schema(description = "Transaction amount", example = "1000.00")
    private BigDecimal amount;

    @Schema(description = "Transaction date and time", example = "2025-03-14T12:34:56")
    private LocalDateTime transactionDate;

    @Schema(description = "Transaction description", example = "ATM Withdrawal")
    private String description;
}

