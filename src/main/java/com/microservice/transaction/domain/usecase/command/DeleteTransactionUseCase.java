package com.microservice.transaction.domain.usecase.command;

import com.microservice.transaction.domain.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTransactionUseCase {

    private final TransactionRepository transactionRepository;

    public DeleteTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public int execute(Long id) {
        return transactionRepository.deleteById(id);
    }
}
