package com.jalja.org.boot.event;

import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {
	@Override

	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("==event["+event+"]===");
	}

}
