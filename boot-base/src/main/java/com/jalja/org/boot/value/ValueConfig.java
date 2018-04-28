package com.jalja.org.boot.value;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
/**
 * 获取配置文件信息
 * @author XL
 *
 */

@Component
public class ValueConfig {
	@Value("${local.ip}")
	private String ip;
	
	@Value("${local.port}")
	private Integer port;
	
	@Value("${local.url}")
	private String url;
	

	

	
	/**
	 * local.defIP 如果该key没有配置 可以使用该方式
	 */
	@Value("${local.defIP:10.99.39.138}")
	private String defIP;
	
	
	@Autowired
	private Environment environment;
	
	public void showValue() {
		System.out.println("@Value 获取:"+ip);
		System.out.println("Environment  获取："+environment.getProperty("local.ip"));
		
		System.out.println("@Value 获取 url:"+url);
		
		System.out.println("@Value 获取 defIP:"+defIP);
		

		
	}
}
