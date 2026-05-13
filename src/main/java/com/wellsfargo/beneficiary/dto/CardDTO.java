package com.wellsfargo.beneficiary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;


@Data
@AllArgsConstructor
public class CardDTO {

    @NotNull(message = "cardId is required")
    private Long cardId;

    @NotBlank(message = "cardNumber is required")
    private String cardNumber;

    @NotBlank(message = "cardType is required")
    private String cardType;

    @NotNull(message = "creditLimit is required")
    private Double creditLimit;

    @NotBlank(message = "status is required")
    private String status;
}