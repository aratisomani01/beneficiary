package com.wellsfargo.beneficiary.service;

import com.wellsfargo.beneficiary.dao.LoanRepository;
import com.wellsfargo.beneficiary.entity.Loan;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        log.debug("Creating loan: {}", loan.getLoanNumber());
        return loanRepository.save(loan);
    }

    public List<Loan> getLoansByBankerId(Long loanId) {
        log.debug("Fetching loans for banker: {}", loanId);
        return loanRepository.findByLoanId(loanId);
    }

    public Loan getLoanById(Long loanId) {
        log.debug("Fetching loan by id: {}", loanId);
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));
    }

    public Loan updateLoan(Loan loan) {
        log.debug("Updating loan: {}", loan.getLoanId());
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long loanId) {
        log.debug("Deleting loan: {}", loanId);
        loanRepository.deleteById(loanId);
    }
}