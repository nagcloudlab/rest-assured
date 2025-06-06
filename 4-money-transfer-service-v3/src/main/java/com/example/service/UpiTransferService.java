package com.example.service;

import com.example.aspects.MyAspect;
import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.entity.Account;
import com.example.entity.TransferHistory;
import com.example.exception.AccountNotFoundException;
import com.example.exception.InsufficientFundsException;
import com.example.repository.AccountRepository;
import com.example.repository.TransferHistoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
public class UpiTransferService implements TransferService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger("money-transfer-service");

    private final AccountRepository accountRepository;
    private final TransferHistoryRepository transferHistoryRepository;

    public UpiTransferService(@Qualifier("jpa") AccountRepository accountRepository,
                              TransferHistoryRepository transferHistoryRepository) {
        this.accountRepository = accountRepository;
        this.transferHistoryRepository = transferHistoryRepository;
        LOGGER.info("UpiTransferService initialized");
    }

    @Transactional(transactionManager = "transactionManager", rollbackFor = Exception.class)
    public TransferResponse transfer(TransferRequest transferRequest) {

        LOGGER.info("Transfer request received: {}", transferRequest);

//        // Step 1: Validate request
//        if (transferRequest.getFromAccount() == null || transferRequest.getToAccount() == null || transferRequest.getAmount() <= 0) {
//            throw new IllegalArgumentException("Invalid transfer request");
//        }

        // Step 2: Fetch accounts
        Account fromAccount = accountRepository.findById(transferRequest.getFromAccount())
                .orElseThrow(() -> new AccountNotFoundException(transferRequest.getFromAccount()));

        Account toAccount = accountRepository.findById(transferRequest.getToAccount())
                .orElseThrow(() -> new AccountNotFoundException(transferRequest.getToAccount()));

        // Step 3: Validate balance
        if (fromAccount.getBalance() < transferRequest.getAmount()) {
            throw new InsufficientFundsException(fromAccount.getNumber(), transferRequest.getAmount());
        }

        // Step 4: Process transfer
        fromAccount.setBalance(fromAccount.getBalance() - transferRequest.getAmount());
        toAccount.setBalance(toAccount.getBalance() + transferRequest.getAmount());

        // Step 5: Persist changes
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);


        // Transfer History
        TransferHistory transferHistory = new TransferHistory();
        transferHistory.setFromAccount(transferRequest.getFromAccount());
        transferHistory.setToAccount(transferRequest.getToAccount());
        transferHistory.setAmount(transferRequest.getAmount());
        transferHistory.setTimestamp(LocalDateTime.now());
        transferHistory.setStatus("SUCCESS");
        LOGGER.info("Transfer history: {}", transferHistory);
        transferHistoryRepository.save(transferHistory);

        // Step 6: Build response
        TransferResponse response = new TransferResponse(
                "TRX" + System.currentTimeMillis(),
                "SUCCESS",
                transferRequest.getFromAccount(),
                transferRequest.getToAccount(),
                transferRequest.getAmount()
        );

        LOGGER.info("Transfer successful: {}", response);
        return response;
    }
}
