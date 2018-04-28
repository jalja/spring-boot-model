package com.jalja.org.boot.event;

import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class MyEventHandle {
	/**
	 * 注册自定义事件
	 * @param event
	 */
	@EventListener
	public void event(MyApplicationEvent event) {
		System.out.println("注册自定义事件["+event+"]");
	}
	/**
	 * 注册spring中的事件
	 * @param event
	 */
	@EventListener
	public void event2(ContextStoppedEvent event) {
		System.out.println("注册spring中的事件["+event+"]");
	}
}
