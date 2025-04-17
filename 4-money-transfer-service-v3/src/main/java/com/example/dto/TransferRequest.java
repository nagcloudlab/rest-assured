package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request to transfer money between accounts")
public class TransferRequest {

    @Schema(description = "Account number from which amount is debited", example = "123456")
    @NotBlank(message = "From account must not be blank")
    private String fromAccount;

    @Schema(description = "Account number to which amount is credited", example = "654321")
    @NotBlank(message = "To account must not be blank")
    private String toAccount;

    @Schema(description = "Amount to transfer", example = "250.75")
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "1", inclusive = true, message = "Amount must be greater than 0")
    private Double amount;

    // Getters and Setters

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                '}';
    }
}
