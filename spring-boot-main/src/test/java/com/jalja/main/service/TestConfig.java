package com.jalja.main.service;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
   @Bean
   public Runnable getRunner() {
	   return ()->{};
   }
}
