package com.jalja.org.quartz.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	
	@Autowired
	private Environment env;
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
      MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
      mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
      mapperScannerConfigurer.setBasePackage(env.getProperty("mybatis.mapper.basePackage"));
      return mapperScannerConfigurer;
   } 
}
