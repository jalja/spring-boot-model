package com.jalja.org.boot.value;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * @PropertySource注解加载配置文件，该注解无法加载yml配置文件
 * @author XL
 *
 */
@Component
@PropertySource("classpath:db_read.properties")
//@PropertySources({@PropertySource("classpath:db2.properties")})
public class DBConfig {
	@Value("${spring.datasource.type}")
	private String type;
	
	public void showValue() {
		System.out.println("@Value 获取 type:"+type);
		
	}
}
