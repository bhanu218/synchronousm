package com.example.demoRestCommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableFeignClients
@SpringBootApplication
public class DemoRestCommunicationApplication {
//	@Bean
//	WebClient webClient() {
//		return WebClient.builder().build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoRestCommunicationApplication.class, args);
	}

}
