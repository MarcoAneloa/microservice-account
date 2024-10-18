package com.microservice.transaction.infrastructure.controller;

import com.microservice.transaction.domain.model.Transaction;
import com.microservice.transaction.domain.usecase.command.CreateTransactionUseCase;
import com.microservice.transaction.domain.usecase.command.DeleteTransactionUseCase;
import com.microservice.transaction.domain.usecase.command.UpdateTransactionUseCase;
import com.microservice.transaction.domain.usecase.query.GetTransactionUseCase;
import com.microservice.transaction.domain.model.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final GetTransactionUseCase getTransactionUseCase;
    private final UpdateTransactionUseCase updateTransactionUseCase;
    private final DeleteTransactionUseCase deleteTransactionUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;

    public TransactionController(GetTransactionUseCase getTransactionUseCase, UpdateTransactionUseCase updateTransactionUseCase, DeleteTransactionUseCase deleteTransactionUseCase, CreateTransactionUseCase createTransactionUseCase) {
        this.getTransactionUseCase = getTransactionUseCase;
        this.updateTransactionUseCase = updateTransactionUseCase;
        this.deleteTransactionUseCase = deleteTransactionUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
    }

    @GetMapping
    ResponseEntity<List<TransactionDTO>> getTransaction() {
        return ResponseEntity.ok().body(getTransactionUseCase.ask());
    }

    @PostMapping
    int saveTransaction(@Valid @RequestBody Transaction transaction) {
        return createTransactionUseCase.execute(transaction);
    }

    @PutMapping
    int updateTransaction(@Valid @RequestBody Transaction transaction) {
        return updateTransactionUseCase.execute(transaction);
    }

    @DeleteMapping("{id}")
    int deleteTransaction(@PathVariable("id") Long id) {
        return deleteTransactionUseCase.execute(id);
    }
}
