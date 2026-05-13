package com.wellsfargo.beneficiary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;


@Data
@AllArgsConstructor
public class AccountDTO {

    @NotNull(message = "accountId is required")
    private Long accountId;

    @NotBlank(message = "accountNumber is required")
    private String accountNumber;

    @NotBlank(message = "accountType is required")
    private String accountType;

    @NotNull(message = "balance is required")
    private Double balance;

    @NotBlank(message = "status is required")
    private String status;
}
