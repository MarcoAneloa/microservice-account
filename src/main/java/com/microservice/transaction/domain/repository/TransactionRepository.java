package com.microservice.transaction.domain.repository;

import com.microservice.transaction.domain.model.Transaction;
import com.microservice.transaction.domain.model.dto.TransactionDTO;

import java.util.List;

public interface TransactionRepository {

    List<TransactionDTO> findAll();

    int save(Transaction transaction);

    int update(Transaction transaction);

    int deleteById(Long id);
}
