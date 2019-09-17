package com.ineat.poc.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ineat.poc.models")
public class GuiApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuiApplication.class, args);
    }
}