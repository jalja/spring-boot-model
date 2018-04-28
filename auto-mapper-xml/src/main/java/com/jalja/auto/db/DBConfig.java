package com.jalja.auto.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")  
public class DBConfig {
	@Bean(name="dataSourceProperties")
	public DataSourceProperties getDataSourceProperties() {
		return new DataSourceProperties();
	} 
	@Bean(name="dataSource")
	public DataSource getDataSource( ) {
		DataSourceProperties properties=getDataSourceProperties();
		DriverManagerDataSource driver=new DriverManagerDataSource();
		driver.setUsername(properties.getUsername());
		driver.setPassword(properties.getPassword());
		driver.setUrl(properties.getJdbcUrl());
		driver.setDriverClassName(properties.getDriverClass());
		return driver;		
	}
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

}
