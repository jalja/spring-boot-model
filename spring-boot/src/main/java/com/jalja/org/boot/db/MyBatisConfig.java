package com.jalja.org.boot.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {
	 /**
	 * 默认读库只有一个
	 */
	private Integer readSize=1;
	
    @Resource(name="druidDataSource")
    DataSource dataSource;
    
    @Resource(name="druidDataSourceRead")
    DataSource druidDataSourceRead;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(roundRobinDataSouceProxy());
        bean.setTypeAliasesPackage("com.jalja.org.boot.model");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
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
    
    /** 
     * 有多少个数据源就要配置多少个bean 
     * @return 
     */  
    @Bean  
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {  
        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource();  
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();  
        targetDataSources.put(DataSourceContextHolder.DataSourceType.write.getType(),dataSource);
        for(int i=0;i<readSize;i++) {
        	targetDataSources.put(i,druidDataSourceRead);
        }
        proxy.setDefaultTargetDataSource(dataSource);  
        proxy.setTargetDataSources(targetDataSources); 
        return proxy;  
    } 
    
    /**
     * 动态数据源选择
     * @author XL
     *
     */
    class MyAbstractRoutingDataSource extends AbstractRoutingDataSource{
        private AtomicInteger count = new AtomicInteger(0);  
        @Override  
        protected Object determineCurrentLookupKey() {  
            String typeKey = DataSourceContextHolder.getJdbcType();  
            if (typeKey==null || typeKey.equals(DataSourceContextHolder.DataSourceType.write.getType())) {
            	logger.info("选择["+DataSourceContextHolder.DataSourceType.write.getType()+"]");
            	 return DataSourceContextHolder.DataSourceType.write.getType();  
            }  
            // 读 简单负载均衡  
            int number = count.getAndAdd(1);  
            int lookupKey = number % readSize;  
            logger.info("选择["+lookupKey+"]");
            return lookupKey;  
        } 
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(roundRobinDataSouceProxy());
    }
}
