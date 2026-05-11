package com.wellsfargo.beneficiary.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class BeneficiaryDTO{
    // Identification
    private String beneficiaryId;        // Unique ID (UUID)
    private String clientId;             // Owner of beneficiary

    // Personal / Entity Details
    private String beneficiaryName;
    private String nickname;             // Optional display name
    private String beneficiaryType;      // INDIVIDUAL / BUSINESS

    // Relationship
    private String relationship;         // Spouse, Son, Vendor, etc.

    // Bank Details
    private String bankName;
    private String bankCode;             // IFSC / SWIFT / Routing Number
    private String accountNumber;
    private String accountType;          // SAVINGS / CURRENT
    private String currency;             // USD, INR, etc.

    // Contact Details (optional but useful)
    private String email;
    private String phoneNumber;

    // Address (for compliance / international transfers)
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String postalCode;

    // Status & Lifecycle
    private String status;               // ACTIVE / PENDING / INACTIVE / REJECTED
    private Boolean isVerified;          // KYC / Bank verification flag

    // Limits & Preferences
    private Double dailyTransferLimit;
    private Double perTransactionLimit;
    private Boolean isFavorite;

    // Audit Fields
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Approval / Maker-Checker
    private String approvalStatus;       // PENDING / APPROVED / REJECTED
    private String approvedBy;
    private LocalDateTime approvedAt;
    private String rejectionReason;

    // Soft Delete
    private Boolean isDeleted;
}