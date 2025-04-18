package com.example.api;

import com.example.dto.AccountResponse;
import com.example.dto.NewAccountRequest;
import com.example.dto.NewAccountResponse;
import com.example.dto.UpdateAccountRequest;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Account", description = "Endpoints for accounts")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Add methods to handle HTTP requests here
    // Create a new account
    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody NewAccountRequest newAccountRequest) {
        Account account = new Account();
        account.setNumber(newAccountRequest.getNumber());
        account.setBalance(newAccountRequest.getBalance());
        accountRepository.save(account);
        NewAccountResponse newAccountResponse = new NewAccountResponse();
        newAccountResponse.setNumber(account.getNumber());
        newAccountResponse.setBalance(account.getBalance());
        newAccountResponse.setStatus("success");
        newAccountResponse.setMessage("Account created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(newAccountResponse);

    }


    // to identify the account : use path variable
    // Get account details
    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable String accountNumber) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setNumber(account.getNumber());
        accountResponse.setBalance(account.getBalance());
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
        return ResponseEntity.ok(accountResponse);
    }

    // Update account details
    @PutMapping("/{accountNumber}")
    public ResponseEntity<?> updateAccount(@PathVariable String accountNumber, @RequestBody UpdateAccountRequest updateAccountRequest) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
        account.setBalance(updateAccountRequest.getBalance());
        accountRepository.save(account);
        return ResponseEntity.ok(account);
    }

    // Delete account
    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable String accountNumber) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
        accountRepository.delete(account);
        return ResponseEntity.ok("Account deleted successfully");
    }

}
