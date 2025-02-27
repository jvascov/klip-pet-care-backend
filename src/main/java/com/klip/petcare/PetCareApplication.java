package com.klip.petcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PetCareApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetCareApplication.class, args);
    }

}
