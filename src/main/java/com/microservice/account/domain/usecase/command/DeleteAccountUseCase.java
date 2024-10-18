package com.microservice.account.domain.usecase.command;

import com.microservice.account.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountUseCase {

    private final AccountRepository accountRepository;

    public DeleteAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public int execute(Long id) {
        return accountRepository.deleteById(id);
    }
}
