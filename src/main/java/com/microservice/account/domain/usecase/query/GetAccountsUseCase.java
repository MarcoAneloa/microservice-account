package com.microservice.account.domain.usecase.query;

import com.microservice.account.domain.model.Account;
import com.microservice.account.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAccountsUseCase {

    private final AccountRepository accountRepository;

    public GetAccountsUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> ask() {
        return accountRepository.findAll();
    }
}
