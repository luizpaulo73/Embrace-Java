package com.fiap.embrace.embrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmbraceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbraceApplication.class, args);
	}

}
