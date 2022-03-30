package com.example.project1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableConfigServer
@EnableFeignClients
@ComponentScan(basePackages={" com.example.usermanagement.ICustomerService"})
public class Project1Application {
	private static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	public static void main(String[] args) {
		logger.info("this is a customer management spring boot application ");
		SpringApplication.run(Project1Application.class, args);
	}

}
