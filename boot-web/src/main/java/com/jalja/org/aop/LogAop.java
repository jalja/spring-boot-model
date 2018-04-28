package com.jalja.org.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
	 //execution  切入点 
	//前置通知 
    @Before(value="execution(* com.jalja.org.aop..*.*(..))")
	public void log() {
		System.out.println(" 前置通知  执行aop 日志");
	}
    @After(value="execution(* com.jalja.org.aop..*.*(..))")
    public void log2(JoinPoint point) {
		System.out.println(" 后置通知  执行aop 日志" +point.getTarget().getClass()+"参数:"+point.getArgs());
	}
}
