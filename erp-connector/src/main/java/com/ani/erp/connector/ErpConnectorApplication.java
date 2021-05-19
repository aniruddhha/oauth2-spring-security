package com.ani.erp.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ErpConnectorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ErpConnectorApplication.class, args);
	}
}
