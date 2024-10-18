package com.microservice.transaction.domain.usecase.command;

import com.microservice.transaction.domain.model.Transaction;
import com.microservice.transaction.domain.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionUseCase {

    private final TransactionRepository transactionRepository;

    public CreateTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public int execute(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
