package com.jalja.org.boot.processor;

import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;
/**
 * 允许定制应用的上下文的应用环境优于应用的上下文之前被刷新。（意思就是在spring上下文构建之前可以设置一些系统配置）
 * EnvironmentPostProcessor的实现类必须要在META-INF/spring.factories文件中去注册，并且注册的是全类名。
 * @author XL
 *
 */
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication arg1) {
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("processor/processor.properties"));
			PropertiesPropertySource source =new PropertiesPropertySource("my",properties);
			environment.getPropertySources().addLast(source);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
