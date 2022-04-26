package com.openclassrooms.SafetynetAlert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.SafetynetAlert.service.CheckerService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
class SafetynetalertApplication implements CommandLineRunner {
	@Autowired
	private CheckerService checkerService;

	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("-------------------------------------------");
		System.out.println("Bienvenue dans SAFETY NET ALERT API VERSION 1.0.0");
		System.out.println("    http://localhost:8080/swagger-ui.html#/      ");
		System.out.println("-------------------------------------------");
		System.out.println("    http://localhost:8080/actuator    ");
		System.out.println("* INFO      : http://localhost:8080/actuator/info      ");
		System.out.println("* HEALTH     : http://localhost:8080/actuator/health    ");
		System.out.println("* BEANS      : http://localhost:8080/actuator/beans     ");
		System.out.println("* METRICS    : http://localhost:8080/actuator/metrics     ");
		System.out.println("* ENV        : http://localhost:8080/actuator/env      ");
		System.out.println("* HTTP TRACE : http://localhost:8080/actuator/httptrace     ");
		System.out.println("-------------------------------------------");

		checkerService.checkingLoadDataJSon();
	}

}
