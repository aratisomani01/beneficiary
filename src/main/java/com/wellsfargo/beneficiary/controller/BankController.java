package com.wellsfargo.beneficiary.controller;

import com.wellsfargo.beneficiary.dto.*;
import com.wellsfargo.beneficiary.dto.CardDTO;
import com.wellsfargo.beneficiary.entity.Account;
import com.wellsfargo.beneficiary.entity.Card;
import com.wellsfargo.beneficiary.entity.Loan;
import com.wellsfargo.beneficiary.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @PostMapping("/transaction/create")
    public String executeTransactions(@RequestBody BankDTO bankDTO) {
        return bankService.runBankServices(bankDTO);
    }

    @PostMapping("/transaction/account/create")
    public Account executeAccountTransactions(@RequestBody AccountDTO accountDTO) {
        return bankService.runAccountServices(accountDTO);
    }

    @PostMapping("/transaction/card/create")
    public Card executeCardTransactions(@RequestBody CardDTO cardDTO) {
        return bankService.runCardServices(cardDTO);
    }

    @PostMapping("/transaction/loan/create")
    public Loan executeLoanTransactions(@RequestBody LoanDTO loanDTO) {
        return bankService.runLoanServices(loanDTO);
    }


}
