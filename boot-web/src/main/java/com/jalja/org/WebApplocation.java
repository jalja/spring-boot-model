package com.jalja.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.jalja.org.aop.TestAopDao;


@ServletComponentScan(basePackages= {"com.jalja.org.servlet"})
@SpringBootApplication(exclude=ErrorMvcAutoConfiguration.class)
public class WebApplocation {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context= SpringApplication.run(WebApplocation.class, args);
	
	   //========================测试 aop=====================
		TestAopDao dao=context.getBean(TestAopDao.class);
		dao.add(10, 11);
		//================================测试手写start================
		DruidDataSource dru=  (DruidDataSource) context.getBean("druidDataSourceStart");
		System.out.println(dru.getUrl());
	}
}
