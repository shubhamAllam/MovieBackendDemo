package com.niit.UserMovieServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class UserMovieServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMovieServicesApplication.class, args);
	}

}
