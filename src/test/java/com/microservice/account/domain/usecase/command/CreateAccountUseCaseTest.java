package com.microservice.account.domain.usecase.command;

import com.microservice.account.domain.model.Account;
import com.microservice.account.domain.repository.AccountRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateAccountUseCaseTest {
    @Mock
    AccountRepository accountRepository;

    @Mock
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1, "", "", 100.0,true,1);
    }

    @Test
    void execute() {

        when(accountRepository.save(account)).thenReturn(1);

        CreateAccountUseCase createAccountUseCase = new CreateAccountUseCase(accountRepository);
        int response = createAccountUseCase.execute(account);

        assertThat(response, Matchers.is(1));
    }

    @Test
    void executeFail() {
        when(accountRepository.save(account)).thenReturn(0);

        CreateAccountUseCase createAccountUseCase = new CreateAccountUseCase(accountRepository);
        int response = createAccountUseCase.execute(account);

        assertThat(response, Matchers.is(0));
    }
}