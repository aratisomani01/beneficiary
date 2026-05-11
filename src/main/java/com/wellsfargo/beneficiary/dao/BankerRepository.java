package com.wellsfargo.beneficiary.dao;

import com.wellsfargo.beneficiary.model.Banker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BankerRepository extends JpaRepository<Banker, Long> {

    Optional<Banker> findByEmail(String email);
}