package com.jalja.org.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DBdataSource {
	@Bean(name="druidDataSource")
	public DataSource  getDruidDataSource() {
		DruidDataSource dataSource=new DruidDataSource();
		return  dataSource;
	}
}
