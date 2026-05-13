package com.wellsfargo.beneficiary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BankDTO {

    private AccountDTO accountDTO;
    private CardDTO cardDTO;
    private LoanDTO loanDTO;

}
