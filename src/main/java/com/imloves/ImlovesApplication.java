package com.imloves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan
@EnableTransactionManagement
public class ImlovesApplication {

    @Bean
    public CacheManager cacheManageer () {
        GuavaCacheManager cacheManager = new GuavaCacheManager("love");
        return cacheManager;
    }

    public static void main(String[] args) {
        SpringApplication.run(ImlovesApplication.class, args);
    }
}
