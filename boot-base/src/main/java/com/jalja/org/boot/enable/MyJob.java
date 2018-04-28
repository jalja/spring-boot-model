package com.jalja.org.boot.enable;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyJob{
	@Async
	public void show() {
		try {
			for(int i=0;i<5;i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("=========["+i+"]=========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
