package com.jalja.org.quartz.db;

import java.sql.SQLException;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
@PropertySource(value = "classpath:db.properties",encoding="UTF-8")
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {	
	private String dbUrl;
    private String username;
    private String password;
    private String driverClassName;
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private int maxWait;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private String filters;

			
	@Bean(name="druidDataSource")
	public DruidDataSource getDruidDataSourceRead() {
	    DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
	}


	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}


	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}


	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}


	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}


	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}


	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}


	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}


	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}


	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}


	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}


	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}


	public void setFilters(String filters) {
		this.filters = filters;
	}
	
	
}
