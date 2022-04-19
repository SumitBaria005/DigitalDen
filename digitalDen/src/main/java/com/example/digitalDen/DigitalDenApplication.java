package com.example.digitalDen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class DigitalDenApplication {
	public static void main(String[] args) {
		SpringApplication.run(DigitalDenApplication.class, args);
	}
}
