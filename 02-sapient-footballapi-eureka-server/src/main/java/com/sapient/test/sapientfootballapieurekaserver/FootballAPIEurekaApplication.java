package com.sapient.test.sapientfootballapieurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FootballAPIEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballAPIEurekaApplication.class, args);
	}
}
