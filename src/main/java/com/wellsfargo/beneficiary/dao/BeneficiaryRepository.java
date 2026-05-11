package com.wellsfargo.beneficiary.dao;

import com.wellsfargo.beneficiary.model.Banker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Banker, Long> {

    // Beneficiary CRUD operations will be added here
    // This will extend JpaRepository once Beneficiary entity is created
}