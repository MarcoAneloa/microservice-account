package com.microservice.account.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Account {

    private Integer id;

    @NotBlank(message = "Number can not be null")
    private String number;

    @NotBlank(message = "Type can not be null")
    private String type;

    @NotNull(message = "Balance can not be null")
    private Double balance;

    @NotNull(message = "State can not be null")
    private Boolean state;

    @NotNull(message = "CustomerId can not be null")
    private Integer customerId;


}
