package com.microservice.account.domain.usecase.query;

import com.microservice.account.domain.model.Account;
import com.microservice.account.domain.repository.AccountRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAccountsUseCaseTest {

    @Mock
    AccountRepository accountRepository;


    @Test
    void askEmpty() {

        when(accountRepository.findAll()).thenReturn(Collections.emptyList());

        GetAccountsUseCase getAccountsUseCase = new GetAccountsUseCase(accountRepository);
        List<Account> accounts = getAccountsUseCase.ask();

        assertThat(accounts, Matchers.is(Matchers.empty()));
    }

    @Test
    void ask() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "", "", 100.0,true,1));

        when(accountRepository.findAll()).thenReturn(accounts);

        GetAccountsUseCase getAccountsUseCase = new GetAccountsUseCase(accountRepository);
        List<Account> response = getAccountsUseCase.ask();

        assertThat(response.size(), Matchers.is(1));
    }
}