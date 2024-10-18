package com.microservice.account.domain.usecase.command;

import com.microservice.account.domain.model.Account;
import com.microservice.account.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public int execute(Account account) {
        return accountRepository.save(account);
    }
}
