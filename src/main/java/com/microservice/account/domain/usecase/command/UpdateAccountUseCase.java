package com.microservice.account.domain.usecase.command;

import com.microservice.account.domain.model.Account;
import com.microservice.account.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase {

    private final AccountRepository accountRepository;


    public UpdateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public int execute(Account account) {
        return accountRepository.update(account);
    }
}
