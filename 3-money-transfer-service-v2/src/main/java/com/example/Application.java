package com.example;

import com.example.repository.AccountRepository;
import com.example.service.TransferService;
import com.example.service.UpiTransferService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger("money-transfer-service");

    public static void main(String[] args) {

        //--------------------------------------
        // init / boot phase
        //--------------------------------------
        LOGGER.info("-".repeat(50));
        SpringApplication.run(Application.class, args);
        LOGGER.info("-".repeat(50));


    }

//    @Bean
//    public CommandLineRunner commandLineRunner(TransferService upiTransferService) {
//        return args -> {
//            upiTransferService.transfer("ACC002", "ACC001", 100);
//        };
//    }

}
