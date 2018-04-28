package com.jalja.org.boot.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EventApp {
	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(EventApp.class);
		//注册时间
		app.addListeners(new MyApplicationListener());
		ConfigurableApplicationContext context=app.run(args);
		//发布事件
		context.publishEvent(new MyApplicationEvent(new Object()));
		context.close();
	}
}
