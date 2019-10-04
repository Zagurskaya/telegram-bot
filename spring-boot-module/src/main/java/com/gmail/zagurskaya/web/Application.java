package com.gmail.zagurskaya.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication(scanBasePackages = {
        "com.gmail.zagurskaya.repository",
        "com.gmail.zagurskaya.service",
        "com.gmail.zagurskaya.web"})
@EntityScan("com.gmail.zagurskaya.repository.model")
public class Application {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(Application.class, args);
    }

}
