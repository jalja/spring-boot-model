package com.jalja.db.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataSourceContextHolder {
	    private static final Logger logger= LoggerFactory.getLogger(DataSourceContextHolder.class);
	 	private static final ThreadLocal<String> local = new ThreadLocal<String>();  
	  
	    public static ThreadLocal<String> getLocal() {  
	        return local;  
	    }  
	    /** 
	     * 读可能是多个库 
	     */  
	    public static void read() {
	    	logger.info("read:["+DataSourceType.read.getType()+"]");
	        local.set(DataSourceType.read.getType());  
	    }  
	    /** 
	     * 写只有一个库 
	     */  
	    public static void write() {
	    	logger.info("write:["+DataSourceType.write.getType()+"]");
	        local.set(DataSourceType.write.getType());  
	    }  
	  
	    public static String getJdbcType() {
	    	String str=local.get();
	    	local.remove();
	        return str;  
	    }  
}
