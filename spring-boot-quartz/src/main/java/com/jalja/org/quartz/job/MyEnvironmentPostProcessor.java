package com.jalja.org.quartz.job;

import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor{
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("quartz.properties"));
			PropertiesPropertySource source =new PropertiesPropertySource("my",properties);
			environment.getPropertySources().addLast(source);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
