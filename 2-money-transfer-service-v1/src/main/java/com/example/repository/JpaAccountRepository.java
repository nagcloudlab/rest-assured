package com.example.repository;

import com.example.entity.Account;

public class JpaAccountRepository implements AccountRepository{

    private static final org.slf4j.Logger LOGGER= org.slf4j.LoggerFactory.getLogger("money-transfer-service");

    public JpaAccountRepository(){
        LOGGER.info("JpaAccountRepository initialized");
    }

    public Account loadAccount(String accountNumber) {
        LOGGER.info("Loading account: {}", accountNumber);
        // Simulate loading an account from a database
        return new Account(accountNumber, 1000.0);
    }

    public void updateAccount(Account account) {
        LOGGER.info("Updating account: {}", account);
        // Simulate updating an account in a database
        LOGGER.info("Account updated: {}", account);
    }

}
