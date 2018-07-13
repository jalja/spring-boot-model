package com.jalja.org.quartz.db;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableConfigurationProperties(value= {DataSourcProperties.class})
public class DataSourceConfig {	
	@Autowired
	private DataSourcProperties dataSourceProperties;
	
	@Bean(name="druidDataSource")
	public DruidDataSource getDruidDataSourceRead() {
	    DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dataSourceProperties.getDbUrl());
        datasource.setUsername(dataSourceProperties.getUsername());
        datasource.setPassword(dataSourceProperties.getPassword());
        datasource.setDriverClassName(dataSourceProperties.getDriverClassName());
        datasource.setInitialSize(dataSourceProperties.getInitialSize());
        datasource.setMinIdle(dataSourceProperties.getMinIdle());
        datasource.setMaxActive(dataSourceProperties.getMaxActive());
        datasource.setMaxWait(dataSourceProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dataSourceProperties.getValidationQuery());
        datasource.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
        datasource.setTestOnReturn(dataSourceProperties.isTestOnReturn());
        try {
            datasource.setFilters(dataSourceProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
	}
}
