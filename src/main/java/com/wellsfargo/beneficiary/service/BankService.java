package com.wellsfargo.beneficiary.service;

import com.wellsfargo.beneficiary.dto.AccountDTO;
import com.wellsfargo.beneficiary.dto.BankDTO;
import com.wellsfargo.beneficiary.dto.CardDTO;
import com.wellsfargo.beneficiary.dto.LoanDTO;
import com.wellsfargo.beneficiary.entity.Account;
import com.wellsfargo.beneficiary.entity.Card;
import com.wellsfargo.beneficiary.entity.Loan;
import com.wellsfargo.beneficiary.mapper.AccountMapper;
import com.wellsfargo.beneficiary.mapper.CardMapper;
import com.wellsfargo.beneficiary.mapper.LoanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankService {

    private final AccountService accountService;
    private final CardService cardService;
    private final LoanService loanService;
    private final AccountMapper accountMapper;
    private final CardMapper cardMapper;
    private final LoanMapper loanMapper;

    @Transactional
    public String runBankServices(BankDTO bankDTO) {
     Account account = runAccountServices(bankDTO.getAccountDTO());
     Card card = runCardServices(bankDTO.getCardDTO());
     Loan loan = runLoanServices(bankDTO.getLoanDTO());

        if (account != null && card != null && loan != null)
            return "Transaction executed successfully!";
        else
            return "Transaction failed";
    }

   public Account runAccountServices(AccountDTO accountDTO) {
       Account account = accountMapper.toEntity(accountDTO);
       setAccountAuditFields(account);
       account = accountService.createAccount(account);
       return account;
   }

    public Card runCardServices(CardDTO cardDTO) {
        Card card = cardMapper.toEntity(cardDTO);
        setCardAuditFields(card);
        card = cardService.createCard(card);
        return card;
    }

    public Loan runLoanServices(LoanDTO loanDTO) {
        Loan loan = loanMapper.toEntity(loanDTO);
        setLoanAuditFields(loan);
        loan = loanService.createLoan(loan);
        return  loan;
    }

    private static void setAccountAuditFields(Account account) {
        account.setCreatedBy("Arati");
        account.setUpdatedBy("Arati");
        account.setCreatedOn(LocalDateTime.now());
        account.setUpdatedOn(LocalDateTime.now());
    }

    private static void setCardAuditFields(Card card) {
        card.setCreatedBy("Arati");
        card.setUpdatedBy("Arati");
        card.setCreatedOn(LocalDateTime.now());
        card.setUpdatedOn(LocalDateTime.now());
    }

    private static void setLoanAuditFields(Loan loan){
         loan.setCreatedBy("Arati");
         loan.setUpdatedBy("Arati");
         loan.setCreatedOn(LocalDateTime.now());
         loan.setUpdatedOn(LocalDateTime.now());
    }

}

