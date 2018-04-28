package com.jalja.auto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MapperConfig {
	@Bean(value="mapperProperties")
	 public MapperProperties getMapperProperties() {
		 return new MapperProperties();
	 }
}
