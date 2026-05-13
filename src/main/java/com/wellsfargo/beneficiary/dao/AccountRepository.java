package com.wellsfargo.beneficiary.dao;

import com.wellsfargo.beneficiary.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // JPA auto-generates SQL for this:
    // SELECT * FROM accounts WHERE account_id = ?
    List<Account> findByAccountId(Long accountId);
}
