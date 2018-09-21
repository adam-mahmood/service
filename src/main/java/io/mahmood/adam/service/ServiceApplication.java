package io.mahmood.adam.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//not best practice to put @RestController on main application class
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServiceApplication {

	@Value("${service.instance.name")
	private String instance;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@RequestMapping("/")
	public String message() {
		return "Hello, from " + instance;

	}
}
