package com.jalja.org.aop;

import org.springframework.stereotype.Component;

@Component
public class TestAopDao {
	public void add(int a,int b) {
		System.out.println("a+b="+(a+b));
	}
}
