package com.wellsfargo.beneficiary.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "banker")
@Data
public class Banker extends AuditBaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long eid;

        @Column(nullable = false, length = 100)
        private String name;

        @Column(nullable = false, unique = true, length = 150)
        private String email;

        @Column(nullable = false, length = 255)
        private String pwd;
    }