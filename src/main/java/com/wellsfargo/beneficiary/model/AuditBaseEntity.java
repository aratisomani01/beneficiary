package com.wellsfargo.beneficiary.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * This class has DB columns but is NOT its own table.
 * Any entity that extends me will inherit these columns into their own table.
 * So accounts, cards and loans tables will all automatically get -
 * created_by, created_on, updated_by, updated_on columns without repeating the code.
 */
@Data
@MappedSuperclass
public abstract class AuditBaseEntity {

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
}
