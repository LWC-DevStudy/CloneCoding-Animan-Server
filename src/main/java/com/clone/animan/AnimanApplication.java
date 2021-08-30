package com.clone.animan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AnimanApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimanApplication.class, args);
    }

}
