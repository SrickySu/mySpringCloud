package com.surichard.myTestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTestServiceApplication.class, args);
	}

}
