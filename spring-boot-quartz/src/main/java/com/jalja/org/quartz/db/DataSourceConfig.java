package com.jalja.org.quartz.db;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.jalja.org.quartz.config.DBProperties;

@Configuration
@EnableConfigurationProperties(value= {DBProperties.class})
public class DataSourceConfig {	

	@Autowired
	private DBProperties dbProperties;
			
	@Bean(name="druidDataSource")
	public DruidDataSource getDruidDataSourceRead() {
	    DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbProperties.getDbUrl());
        datasource.setUsername(dbProperties.getUsername());
        datasource.setPassword(dbProperties.getPassword());
        datasource.setDriverClassName(dbProperties.getDriverClassName());
        datasource.setInitialSize(dbProperties.getInitialSize());
        datasource.setMinIdle(dbProperties.getMinIdle());
        datasource.setMaxActive(dbProperties.getMaxActive());
        datasource.setMaxWait(dbProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dbProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dbProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dbProperties.getValidationQuery());
        datasource.setTestWhileIdle(dbProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(dbProperties.isTestOnBorrow());
        datasource.setTestOnReturn(dbProperties.isTestOnReturn());
        try {
            datasource.setFilters(dbProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
	}
}
