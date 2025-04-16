package com.example.repository;

import com.example.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository{

    private static final org.slf4j.Logger LOGGER= org.slf4j.LoggerFactory.getLogger("money-transfer-service");

    @PersistenceContext
    private EntityManager entityManager;

    public JpaAccountRepository(){
        LOGGER.info("JpaAccountRepository initialized");
    }

    public Account loadAccount(String accountNumber) {
        LOGGER.info("Loading account: {}", accountNumber);
        return entityManager.find(Account.class, accountNumber); // select * from account where account_number = accountNumber
    }

    public void updateAccount(Account account) {
        LOGGER.info("Updating account: {}", account);
        entityManager.merge(account); // update account set balance = ? where account_number = ?
        LOGGER.info("Account updated: {}", account);
    }

}
