package com.example.teachertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TeachertaskApplication {

    public static void main(String[] args) {

        SpringApplication.run(TeachertaskApplication.class, args);

    }

}
