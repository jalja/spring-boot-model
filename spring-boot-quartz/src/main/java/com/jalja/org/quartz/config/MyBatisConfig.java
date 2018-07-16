package com.jalja.org.quartz.config;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer{
	
	private static final Logger logger= LoggerFactory.getLogger(MyBatisConfig.class);
	@Autowired
	private DruidDataSource druidDataSource;
	@Value(value="${mybatis.mapper.aliasesPackage}")
	private String  aliasesPackage="com.jalja.org.quartz.model";
	@Value(value="${mybatis.mapper.mapperScanner}")
	private String  mapperScanner="com.jalja.org.quartz.mapper";
	@Value(value="${mybatis.mapper.mapperLocations}")
	private String mapperLocations="classpath:/mapper/*.xml";
	
	@PostConstruct
    public void init() {
    	logger.info("MyBatisConfig>>>");
    }
	
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(druidDataSource);
        bean.setTypeAliasesPackage(aliasesPackage);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(mapperLocations));
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        //添加插件
        bean.setPlugins(new Interceptor[]{pageHelper});
        return bean.getObject();
    }
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		  return new DataSourceTransactionManager(druidDataSource);
	}
	public void setAliasesPackage(String aliasesPackage) {
		this.aliasesPackage = aliasesPackage;
	}
	
	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
	
}
