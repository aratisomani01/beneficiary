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
@Table(name = "accounts")
public class Account extends AuditBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "account_number", nullable = false, length = 20)
    private String accountNumber;

    @Column(name = "account_type", nullable = false, length = 50)
    private String accountType;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false, length = 20)
    private String status;
}
