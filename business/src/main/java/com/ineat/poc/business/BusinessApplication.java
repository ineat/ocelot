package com.ineat.poc.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BusinessApplication {
	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}
}
