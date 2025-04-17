package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import com.example.service.TransferService;
import com.example.service.UpiTransferService;

public class Application {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger("money-transfer-service");

    public static void main(String[] args) {

        //--------------------------------------
        // init / boot phase ,
        //--------------------------------------
        LOGGER.info("-".repeat(50));
        AccountRepository jdbcAccountRepository = AccountRepositoryFactory.getAccountRepository("jdbc");
        TransferService upiTransferService = new UpiTransferService(jdbcAccountRepository);
        LOGGER.info("-".repeat(50));
        //---------------------------------------
        // use phase
        //---------------------------------------

        upiTransferService.transfer("user1@upi", "user2@upi", 100);
        LOGGER.info("-".repeat(50));
        upiTransferService.transfer("user1@upi", "user2@upi", 100);

        //---------------------------------------
        // shutdown phase
        //---------------------------------------
        LOGGER.info("-".repeat(50));


        // Perform any necessary cleanup or shutdown operations here
        LOGGER.info("-".repeat(50));


    }
}
