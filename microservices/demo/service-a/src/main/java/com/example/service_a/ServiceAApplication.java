package com.example.service_a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@RestController
public class ServiceAApplication {

	@Value("${server.port}")
	private int port;

	@GetMapping("/request-1")
	public String getMethodName() {
		System.out.println("service instace received request");
		return "Hello from Service A! Port: " + port;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

}
