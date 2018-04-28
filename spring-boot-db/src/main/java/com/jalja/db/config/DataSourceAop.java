package com.jalja.db.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jalja.db.source.MapperProperties;


@Aspect  
@Component 
public class DataSourceAop {
	 private static final Logger logger= LoggerFactory.getLogger(DataSourceAop.class);
	 @Autowired
	 private MapperProperties mapperProperties;
	 
	 @Before("execution(* com.jalja.main.mapper..*.*(..))")  
     public void beforeAdvice(JoinPoint joinPoint) {
		if(Boolean.parseBoolean(mapperProperties.getIsRead())==false) {
			 DataSourceContextHolder.write();
			 return;
		}
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
