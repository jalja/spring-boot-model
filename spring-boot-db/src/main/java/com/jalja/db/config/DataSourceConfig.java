package com.jalja.db.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.jalja.db.source.DataSourceReadProperties;
import com.jalja.db.source.DataSourceWriteProperties;
import com.jalja.db.source.MapperProperties;

@Configuration
@EnableConfigurationProperties(value= {DataSourceReadProperties.class,DataSourceWriteProperties.class})
public class DataSourceConfig {
	@Autowired
	private DataSourceReadProperties dataSourceReadProperties;
	
	@Autowired
	private DataSourceWriteProperties dataSourceWriteProperties;
	
	@Bean(value="dataSourceRead")
	public DataSource getDruidDataSourceRead() {
	    DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dataSourceReadProperties.getDbUrl());
        datasource.setUsername(dataSourceReadProperties.getUsername());
        datasource.setPassword(dataSourceReadProperties.getPassword());
        datasource.setDriverClassName(dataSourceReadProperties.getDriverClassName());
        datasource.setInitialSize(dataSourceReadProperties.getInitialSize());
        datasource.setMinIdle(dataSourceReadProperties.getMinIdle());
        datasource.setMaxActive(dataSourceReadProperties.getMaxActive());
        datasource.setMaxWait(dataSourceReadProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dataSourceReadProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dataSourceReadProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dataSourceReadProperties.getValidationQuery());
        datasource.setTestWhileIdle(dataSourceReadProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(dataSourceReadProperties.isTestOnBorrow());
        datasource.setTestOnReturn(dataSourceReadProperties.isTestOnReturn());
        try {
            datasource.setFilters(dataSourceReadProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
	}
	@Bean(value="dataSourceWriter")
	@Primary
	public DataSource getDruidDataSourceWriter() {
	    DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dataSourceWriteProperties.getDbUrl());
        datasource.setUsername(dataSourceWriteProperties.getUsername());
        datasource.setPassword(dataSourceWriteProperties.getPassword());
        datasource.setDriverClassName(dataSourceWriteProperties.getDriverClassName());
        datasource.setInitialSize(dataSourceWriteProperties.getInitialSize());
        datasource.setMinIdle(dataSourceWriteProperties.getMinIdle());
        datasource.setMaxActive(dataSourceWriteProperties.getMaxActive());
        datasource.setMaxWait(dataSourceWriteProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dataSourceWriteProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dataSourceWriteProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dataSourceWriteProperties.getValidationQuery());
        datasource.setTestWhileIdle(dataSourceWriteProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(dataSourceWriteProperties.isTestOnBorrow());
        datasource.setTestOnReturn(dataSourceWriteProperties.isTestOnReturn());
        try {
            datasource.setFilters(dataSourceWriteProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
	}
	@Bean(value="mapperProperties")
	public MapperProperties getMapperProperties() {
		return new MapperProperties();
	}
	@Bean(value="dataSourceAop")
	public DataSourceAop getDataSourceAop() {
		return new DataSourceAop();
	}

}
