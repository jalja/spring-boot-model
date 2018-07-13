package com.jalja.org.quartz.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	@PostConstruct
	private void init() {
		System.out.println("加载 service");
	}
	public void myTest() {
		System.out.println("Hello Word：");
    }
}
