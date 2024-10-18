package com.microservice.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = "com.microservice.account," + "com.microservice.transaction," +
        "com.store.microservice.shared,")
@Configuration
public class ConfigApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
