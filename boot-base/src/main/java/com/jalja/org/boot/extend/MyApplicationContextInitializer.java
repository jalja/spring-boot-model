package com.jalja.org.boot.extend;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * ApplicationContextInitializer 接口在spring容器执行refreshed之前回调
 * @author XL
 *
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext context) {
		System.out.println("bena 个数"+context.getBeanDefinitionCount());
		
	}

}
