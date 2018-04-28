package com.jalja.org.boot.extend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyCommandLineRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("================应用启动成功后回调MyCommandLineRunner2==============");

	}

}
