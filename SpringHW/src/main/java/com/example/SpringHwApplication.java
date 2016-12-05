package com.example;

import com.example.model.ItemDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHwApplication {

    @Bean
    public ItemDAO create() {
        return new ItemDAO();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringHwApplication.class, args);
    }
}
