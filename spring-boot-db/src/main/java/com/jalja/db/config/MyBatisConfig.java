package com.jalja.db.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageHelper;
import com.jalja.db.source.MapperProperties;

@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {
    @Resource(name="dataSourceWriter")
    DataSource dataSourceWriter;
    
    @Resource(name="dataSourceRead")
    DataSource dataSourceRead;
    @Autowired
    MapperProperties mapperProperties;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        
        bean.setDataSource(Boolean.parseBoolean(mapperProperties.getIsRead())==true?roundRobinDataSouceProxy():dataSourceWriter);
        bean.setTypeAliasesPackage(mapperProperties.getAliasesPackage());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(mapperProperties.getMapperLocations()));
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
              有多少个数据源就要配置多少个bean 
      */
    @Bean  
    public AbstractRoutingDataSource roundRobinDataSouceProxy() {  
        int size = mapperProperties.getReadNum();  
        MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(size);  
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();  
        //DataSource writeDataSource = SpringContextHolder.getBean("writeDataSource");  
        // 写  
        targetDataSources.put(DataSourceType.write.getType(),dataSourceWriter);  
        // targetDataSources.put(DataSourceType.read.getType(),readDataSource);  
        //多个读数据库时  
        targetDataSources.put(DataSourceType.read.getIndex(),dataSourceRead);
        proxy.setDefaultTargetDataSource(dataSourceWriter);  
        proxy.setTargetDataSources(targetDataSources); 
        return proxy;  
    } 
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(Boolean.parseBoolean(mapperProperties.getIsRead())?roundRobinDataSouceProxy():dataSourceWriter);
    }
}
