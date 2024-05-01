package com.thinkitive.microservices.currencyconversionservicemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceMicroserviceApplication.class, args);
	}

}
