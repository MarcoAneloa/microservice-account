package com.microservice.account.domain.repository;

import com.microservice.account.domain.model.Account;

import java.util.List;

public interface AccountRepository {

    List<Account> findAll();

    int save(Account account);

    int update(Account account);

    int deleteById(Long id);
}
