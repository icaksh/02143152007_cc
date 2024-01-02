package com.example.plusserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlusServerApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "4000");
		SpringApplication.run(PlusServerApplication.class, args);
	}

}
