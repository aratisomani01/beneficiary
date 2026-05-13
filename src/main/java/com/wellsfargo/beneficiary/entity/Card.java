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
@Table(name = "cards")
public class Card extends AuditBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(name = "card_number", nullable = false, unique = true, length = 20)
    private String cardNumber;

    @Column(name = "card_type", nullable = false, length = 50)
    private String cardType;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @Column(nullable = false, length = 20)
    private String status;
}
