package com.jalja.org.quartz.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	
	 @Value(value="${mybatis.mapper.mapperScanner}")
	 private String  mapperScanner="com.jalja.org.quartz.mapper";
	  @Bean
	  public MapperScannerConfigurer mapperScannerConfigurer() {
	      MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
	      mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	      mapperScannerConfigurer.setBasePackage(mapperScanner);
	      return mapperScannerConfigurer;
	  }
	public String getMapperScanner() {
		return mapperScanner;
	}
	public void setMapperScanner(String mapperScanner) {
		this.mapperScanner = mapperScanner;
	}
	 
}
