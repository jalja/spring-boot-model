package com.jalja.org.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;

import com.jalja.org.boot.conditional.ConditionConfig;
import com.jalja.org.boot.value.ConfigurationPropertiesValue;
import com.jalja.org.boot.value.DBConfig;
import com.jalja.org.boot.value.ValueConfig;

/**
 * springboot 配置文件默认classpath跟目录下的application.propertiees 。
 * 也可以通过指定--spring.config.name=配置文件名 来随意起配置文件名称。
 * 
 * @author XL
 *
 */
@SpringBootApplication
public class SpringBootApp {
	public static void main(String[] args) {
		//=========================spring boot 读取配置文件==================
		/*ConfigurableApplicationContext config= SpringApplication.run(SpringBootApp.class, args);
		System.out.println(config.getEnvironment().getProperty("local.ip"));
		config.getBean(ValueConfig.class).showValue();
		config.getBean(DBConfig.class).showValue();
		config.getBean(ConfigurationPropertiesValue.class).showValue();
		
		//=======================EnvironmentPostProcessor=================
		System.out.println(config.getEnvironment().getProperty("processor"));*/
		
		//======================Profile 根据不同的环境读取不同的配置信息==============
		SpringApplication application=new SpringApplication(SpringBootApp.class);
		application.setAdditionalProfiles("dev");
		ConfigurableApplicationContext config= application.run(args);
		System.out.println(config.getEnvironment().getProperty("spring.datasource.url"));
		Runnable ru=(Runnable) config.getBean("getRunnable");
		
		
	}
}
