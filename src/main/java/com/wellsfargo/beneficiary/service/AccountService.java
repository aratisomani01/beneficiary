package com.wellsfargo.beneficiary.service;

import com.wellsfargo.beneficiary.dao.AccountRepository;
import com.wellsfargo.beneficiary.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    // INSERT into accounts
    public Account createAccount(Account account) {
        log.debug("Creating account: {}", account.getAccountNumber());
        return accountRepository.save(account);
    }

    // SELECT * FROM accounts WHERE banker_id = ?
    public List<Account> getAccountsByAccountId(Long accountId) {
        log.debug("Fetching accounts for banker: {}", accountId);
        return accountRepository.findByAccountId(accountId);
    }

    // SELECT * FROM accounts WHERE account_id = ?
    public Account getAccountById(Long accountId) {
        log.debug("Fetching account by id: {}", accountId);
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));
    }

    // UPDATE accounts SET ... WHERE account_id = ?
    public Account updateAccount(Account account) {
        log.debug("Updating account: {}", account.getAccountId());
        return accountRepository.save(account); // save() does INSERT or UPDATE based on ID
    }

    // DELETE FROM accounts WHERE account_id = ?
    public void deleteAccount(Long accountId) {
        log.debug("Deleting account: {}", accountId);
        accountRepository.deleteById(accountId);
    }
}