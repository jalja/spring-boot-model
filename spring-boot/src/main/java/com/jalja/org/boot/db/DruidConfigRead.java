package com.jalja.org.boot.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfigRead {
	 private Logger logger = LoggerFactory.getLogger(DruidConfigRead.class);

	    @Value("${spring.datasource.url_read}")
	    private String dbUrl;

	    @Value("${spring.datasource.username_read}")
	    private String username;

	    @Value("${spring.datasource.password_read}")
	    private String password;

	    @Value("${spring.datasource.driver-class-name_read}")
	    private String driverClassName;

	    @Value("${spring.datasource.initialSize_read}")
	    private int initialSize;

	    @Value("${spring.datasource.minIdle_read}")
	    private int minIdle;

	    @Value("${spring.datasource.maxActive_read}")
	    private int maxActive;

	    @Value("${spring.datasource.maxWait_read}")
	    private int maxWait;

	    @Value("${spring.datasource.timeBetweenEvictionRunsMillis_read}")
	    private int timeBetweenEvictionRunsMillis;

	    @Value("${spring.datasource.minEvictableIdleTimeMillis_read}")
	    private int minEvictableIdleTimeMillis;

	    @Value("${spring.datasource.validationQuery_read}")
	    private String validationQuery;

	    @Value("${spring.datasource.testWhileIdle_read}")
	    private boolean testWhileIdle;

	    @Value("${spring.datasource.testOnBorrow_read}")
	    private boolean testOnBorrow;

	    @Value("${spring.datasource.testOnReturn_read}")
	    private boolean testOnReturn;

	    @Value("${spring.datasource.filters_read}")
	    private String filters;

	    @Value("${spring.datasource.logSlowSql_read}")
	    private String logSlowSql;
	    
	    @Bean(value="druidServletRead")
	    public ServletRegistrationBean druidServlet() {
	        ServletRegistrationBean reg = new ServletRegistrationBean();
	        reg.setServlet(new StatViewServlet());
	        reg.addUrlMappings("/druid/*");
	        reg.addInitParameter("loginUsername", username);
	        reg.addInitParameter("loginPassword", password);
	        reg.addInitParameter("logSlowSql", logSlowSql);
	        return reg;
	    }

	    @Bean(value="filterRegistrationBeanRead")
	    public FilterRegistrationBean filterRegistrationBean() {
	        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
	        filterRegistrationBean.setFilter(new WebStatFilter());
	        filterRegistrationBean.addUrlPatterns("/*");
	        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
	        filterRegistrationBean.addInitParameter("profileEnable", "true");
	        return filterRegistrationBean;
	    }

	    @Bean(value="druidDataSourceRead")
	    public DataSource druidDataSource() {
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
	            logger.error("druid configuration initialization filter", e);
	        }
	        return datasource;
	    }
}
