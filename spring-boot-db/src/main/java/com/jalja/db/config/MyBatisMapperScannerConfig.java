package com.jalja.db.config;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jalja.db.source.MapperProperties;
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	
   @Autowired
   MapperProperties mapperProperties;
	
  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
      MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
      mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
      mapperScannerConfigurer.setBasePackage(mapperProperties.getMapperScanner());
      return mapperScannerConfigurer;
  }

}