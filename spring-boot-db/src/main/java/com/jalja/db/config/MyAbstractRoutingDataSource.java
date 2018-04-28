package com.jalja.db.config;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;



public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {  
    private final int dataSourceNumber;  
    private AtomicInteger count = new AtomicInteger(0);  
  
    public MyAbstractRoutingDataSource(int dataSourceNumber) {  
        this.dataSourceNumber = dataSourceNumber;  
    }  
  
    @Override  
    protected Object determineCurrentLookupKey() {  
        String typeKey = DataSourceContextHolder.getJdbcType();  
        if (StringUtils.isEmpty(typeKey) || typeKey.equals(DataSourceType.write.getType())) {
        	 return DataSourceType.write.getType();  
        }  
        // 读 简单负载均衡  
        int number = count.getAndAdd(1);  
        int lookupKey = number % dataSourceNumber;  
        System.out.println("lookupKey["+lookupKey+"]");
        return lookupKey;  
    }  
}
