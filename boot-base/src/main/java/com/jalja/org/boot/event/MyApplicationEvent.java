package com.jalja.org.boot.event;

import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	public MyApplicationEvent(Object source) {
		super(source);
	}

}
