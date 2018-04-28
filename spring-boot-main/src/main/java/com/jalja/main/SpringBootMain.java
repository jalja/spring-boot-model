package com.jalja.main;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jalja.main.zookeeper.ServerClient;

@SpringBootApplication
public class SpringBootMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=SpringApplication.run(SpringBootMain.class, args);
		ServerClient serverClient=(ServerClient) context.getBean(ServerClient.class);
		String str=serverClient.getServer("springMain");
		System.out.println(str);
	}

}
