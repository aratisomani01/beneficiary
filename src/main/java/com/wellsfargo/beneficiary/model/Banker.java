package com.wellsfargo.beneficiary.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "banker")
@Data
public class Banker {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long eid;

        @Column(nullable = false, length = 100)
        private String name;

        @Column(nullable = false, unique = true, length = 150)
        private String email;

        @Column(nullable = false, length = 255)
        private String pwd;

        @Column(name = "created_by", length = 100)
        private String createdBy;

        @Column(name = "created_on")
        private LocalDateTime createdOn;

        @Column(name = "updated_by", length = 100)
        private String updatedBy;

        @Column(name = "updated_on")
        private LocalDateTime updatedOn;

    }