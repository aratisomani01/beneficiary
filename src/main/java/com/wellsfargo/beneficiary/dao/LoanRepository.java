package com.wellsfargo.beneficiary.dao;

import com.wellsfargo.beneficiary.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByLoanId(Long loanId);
}