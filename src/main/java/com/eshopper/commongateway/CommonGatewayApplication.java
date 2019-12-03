package com.eshopper.commongateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
public class CommonGatewayApplication {

	public static void main(String[] args) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		SpringApplication.run(CommonGatewayApplication.class, args);
	}

}
