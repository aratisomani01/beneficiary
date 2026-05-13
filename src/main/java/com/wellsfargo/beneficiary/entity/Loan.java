package com.wellsfargo.beneficiary.entity;
import com.wellsfargo.beneficiary.model.AuditBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loans")
public class Loan extends AuditBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "loan_number", nullable = false, unique = true, length = 20)
    private String loanNumber;

    @Column(name = "loan_type", nullable = false, length = 50)
    private String loanType;

    @Column(name = "loan_amount", nullable = false)
    private Double loanAmount;

    @Column(name = "outstanding_amount", nullable = false)
    private Double outstandingAmount;

    @Column(nullable = false, length = 20)
    private String status;
}
