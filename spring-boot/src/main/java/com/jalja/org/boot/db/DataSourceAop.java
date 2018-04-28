package com.jalja.org.boot.db;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect  
@Component 
public class DataSourceAop {
	 private static final Logger logger= LoggerFactory.getLogger(DataSourceAop.class);
	 @Before("execution(* com.jalja.org.boot.mapper..*.*(..))")  
     public void beforeAdvice(JoinPoint joinPoint) {   
        String methodName = joinPoint.getSignature().getName();
        if(methodName.indexOf("insert")!=-1) {
        	logger.info("dataSource切换到：write"); 
        	DataSourceContextHolder.write();  
        }else {
        	logger.info("dataSource切换到：Read"); 
        	 DataSourceContextHolder.read();  
        }  
     }   
}
