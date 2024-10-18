package com.microservice.transaction.domain.usecase.query;

import com.microservice.transaction.domain.model.Transaction;
import com.microservice.transaction.domain.model.dto.TransactionDTO;
import com.microservice.transaction.domain.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionUseCase {

    private final TransactionRepository transactionRepository;

    public GetTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDTO> ask() {
        return transactionRepository.findAll();
    }
}
