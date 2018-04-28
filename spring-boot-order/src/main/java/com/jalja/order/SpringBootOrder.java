package com.jalja.order;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootOrder {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=SpringApplication.run(SpringBootOrder.class, args);
	}

}
