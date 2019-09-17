package com.ineat.poc.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "com.ineat.poc.models")
public class BeerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeerApplication.class, args);
	}
}
