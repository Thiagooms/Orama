package com.orama.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		EnvLoader.load();
		SpringApplication.run(AppApplication.class, args);
	}

}
