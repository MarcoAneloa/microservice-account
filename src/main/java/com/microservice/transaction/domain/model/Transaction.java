package com.microservice.transaction.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Transaction {
    private Integer id;
}
