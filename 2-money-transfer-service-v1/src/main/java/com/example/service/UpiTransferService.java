package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import com.example.repository.JdbcAccountRepository;

public class UpiTransferService implements TransferService {

    private static final org.slf4j.Logger LOGGER= org.slf4j.LoggerFactory.getLogger("money-transfer-service");


    private AccountRepository accountRepository;

    // Constructor injection
    public UpiTransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository; // Use the injected repository
        LOGGER.info("UpiTransferService initialized");
    }

    public void transfer(String fromAccountId, String toAccountId, double amount) {

        LOGGER.info("Transferring {} from {} to {}", amount, fromAccountId, toAccountId);

        //JdbcAccountRepository accountRepository=new JdbcAccountRepository(); // Don't create, get from factory
        //AccountRepository accountRepository= AccountRepositoryFactory.getAccountRepository("jdbc"); // Don't create, get from factory

        // step-1: load the from account
        Account fromAccount=accountRepository.loadAccount(fromAccountId);
        // step-2: load the to account
        Account toAccount=accountRepository.loadAccount(toAccountId);
        // step-3: check if the from account has sufficient balance
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        // step-4: deduct the amount from the from account
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        // step-5: add the amount to the to account
        toAccount.setBalance(toAccount.getBalance() + amount);

        // step-6: update the from account
        accountRepository.updateAccount(fromAccount);
        // step-7: update the to account
        accountRepository.updateAccount(toAccount);

        LOGGER.info("Transfer successful: {} from {} to {}", amount, fromAccountId, toAccountId);

    }

}
