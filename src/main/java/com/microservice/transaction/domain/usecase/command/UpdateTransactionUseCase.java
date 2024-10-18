package com.microservice.transaction.domain.usecase.command;

import com.microservice.transaction.domain.model.Transaction;
import com.microservice.transaction.domain.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionUseCase {

    private final TransactionRepository transactionRepository;


    public UpdateTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public int execute(Transaction transaction) {
        return transactionRepository.update(transaction);
    }
}
