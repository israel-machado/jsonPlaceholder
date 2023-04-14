package com.example.jsonplaceholder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JsonplaceholderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonplaceholderApplication.class, args);
	}
}
