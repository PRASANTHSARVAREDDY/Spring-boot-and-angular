package com.telusko.springmvcboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.telusko.springmvcboot"})
public class SpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

}
