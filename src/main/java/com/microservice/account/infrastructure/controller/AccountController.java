package com.microservice.account.infrastructure.controller;

import com.microservice.account.domain.model.Account;
import com.microservice.account.domain.usecase.command.CreateAccountUseCase;
import com.microservice.account.domain.usecase.command.DeleteAccountUseCase;
import com.microservice.account.domain.usecase.command.UpdateAccountUseCase;
import com.microservice.account.domain.usecase.query.GetAccountsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private final GetAccountsUseCase getAccountsUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final CreateAccountUseCase createAccountUseCase;

    public AccountController(GetAccountsUseCase getAccountsUseCase, UpdateAccountUseCase updateAccountUseCase, DeleteAccountUseCase deleteAccountUseCase, CreateAccountUseCase createAccountUseCase) {
        this.getAccountsUseCase = getAccountsUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
        this.createAccountUseCase = createAccountUseCase;
    }

    @GetMapping
    ResponseEntity<List<Account>> getCustomers() {
        return ResponseEntity.ok().body(getAccountsUseCase.ask());
    }

    @PostMapping
    int saveCustomer(@Valid @RequestBody Account account) {
        return createAccountUseCase.execute(account);
    }

    @PutMapping
    int updateCustomer(@Valid @RequestBody Account account) {
        return updateAccountUseCase.execute(account);
    }

    @DeleteMapping("{id}")
    int deleteCustomer(@PathVariable("id") Long id) {
        return deleteAccountUseCase.execute(id);
    }
}
