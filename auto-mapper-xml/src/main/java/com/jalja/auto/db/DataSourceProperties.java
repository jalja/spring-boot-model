package com.jalja.auto.db;

import org.springframework.beans.factory.annotation.Value;

public class DataSourceProperties{
	@Value(value="${jdbc.username}")
	private String username;
	@Value(value="${jdbc.password}")
	private String password;
	@Value(value="${jdbc.driverClass}")
	private String driverClass;
	@Value(value="${jdbc.jdbcUrl}")
	private String jdbcUrl;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	
}
