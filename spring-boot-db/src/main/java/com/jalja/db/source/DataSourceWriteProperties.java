package com.jalja.db.source;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "spring.datasource.writer")
public class DataSourceWriteProperties {
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
	    private String logSlowSql;
		public String getDbUrl() {
			return dbUrl;
		}
		public void setDbUrl(String dbUrl) {
			this.dbUrl = dbUrl;
		}
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
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		public int getInitialSize() {
			return initialSize;
		}
		public void setInitialSize(int initialSize) {
			this.initialSize = initialSize;
		}
		public int getMinIdle() {
			return minIdle;
		}
		public void setMinIdle(int minIdle) {
			this.minIdle = minIdle;
		}
		public int getMaxActive() {
			return maxActive;
		}
		public void setMaxActive(int maxActive) {
			this.maxActive = maxActive;
		}
		public int getMaxWait() {
			return maxWait;
		}
		public void setMaxWait(int maxWait) {
			this.maxWait = maxWait;
		}
		public int getTimeBetweenEvictionRunsMillis() {
			return timeBetweenEvictionRunsMillis;
		}
		public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
			this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
		}
		public int getMinEvictableIdleTimeMillis() {
			return minEvictableIdleTimeMillis;
		}
		public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
			this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
		}
		public String getValidationQuery() {
			return validationQuery;
		}
		public void setValidationQuery(String validationQuery) {
			this.validationQuery = validationQuery;
		}
		public boolean isTestWhileIdle() {
			return testWhileIdle;
		}
		public void setTestWhileIdle(boolean testWhileIdle) {
			this.testWhileIdle = testWhileIdle;
		}
		public boolean isTestOnBorrow() {
			return testOnBorrow;
		}
		public void setTestOnBorrow(boolean testOnBorrow) {
			this.testOnBorrow = testOnBorrow;
		}
		public boolean isTestOnReturn() {
			return testOnReturn;
		}
		public void setTestOnReturn(boolean testOnReturn) {
			this.testOnReturn = testOnReturn;
		}
		public String getFilters() {
			return filters;
		}
		public void setFilters(String filters) {
			this.filters = filters;
		}
		public String getLogSlowSql() {
			return logSlowSql;
		}
		public void setLogSlowSql(String logSlowSql) {
			this.logSlowSql = logSlowSql;
		}

}
