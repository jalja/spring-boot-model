package com.jalja.org.quartz;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class QuartzApplicationMain {

	public static void main(String[] args) throws Exception {
		 ConfigurableApplicationContext config= SpringApplication.run(QuartzApplicationMain.class, args);
	}
}
