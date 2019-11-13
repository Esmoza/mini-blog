package com.auk.project.miniblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MiniBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBlogApplication.class, args);
	}

}
