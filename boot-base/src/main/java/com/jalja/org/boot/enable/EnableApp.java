package com.jalja.org.boot.enable;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import({MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class EnableApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext config=SpringApplication.run(EnableApp.class,args);
		config.getBean(MyJob.class).show();
		System.out.println("===========结束=========");
		
		System.out.println(config.getBeansOfType(EnbleUser.class));
		
		System.out.println(config.getBean("user"));
		
		
	}
}
