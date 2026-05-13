package com.wellsfargo.beneficiary.dto;

import com.wellsfargo.beneficiary.model.AuditBaseEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoanDTO extends AuditBaseEntity {

    @NotNull(message = "loanId is required")
    private Long loanId;

    @NotBlank(message = "loanNumber is required")
    private String loanNumber;

    @NotBlank(message = "loanType is required")
    private String loanType;

    @NotNull(message = "loanAmount is required")
    private Double loanAmount;

    @NotNull(message = "outstandingAmount is required")
    private Double outstandingAmount;

    @NotBlank(message = "status is required")
    private String status;
}
