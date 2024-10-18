package com.microservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(AccountApplication.class, args);
    }

}
