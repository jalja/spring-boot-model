package com.jalja.order.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class AppConfig {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
