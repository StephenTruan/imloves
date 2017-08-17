package com.imloves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ImlovesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImlovesApplication.class, args);
    }
}
