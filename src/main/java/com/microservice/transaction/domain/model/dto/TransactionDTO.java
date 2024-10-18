package com.microservice.transaction.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDTO {
    private Integer id;
    private String date;
    private String name;
    private String number;
    private String type;
    private Boolean status;
    private Double initialBalance;
    private Double finalBalance;
    private Double value;
}
