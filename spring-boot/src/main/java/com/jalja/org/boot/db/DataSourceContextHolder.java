package com.jalja.org.boot.db;


public class DataSourceContextHolder {
	 	private static final ThreadLocal<String> local = new ThreadLocal<String>();  
	  
	    public static ThreadLocal<String> getLocal() {  
	        return local;  
	    }  
	    /** 
	     * 读可能是多个库 
	     */  
	    public static void read() {
	        local.set(DataSourceType.read.getType());  
	    }  
	    /** 
	     * 写只有一个库 
	     */  
	    public static void write() {
	        local.set(DataSourceType.write.getType());  
	    }  
	  
	    public static String getJdbcType() {  
	    	String str=local.get();
	    	local.remove();
	        return str;  
	    } 
	    enum DataSourceType {
		 	read("read", "readDB"),  
		    write("write", "writeDB");  
	  
		    private String type;  
	  
		    private String name;  
		  
		    DataSourceType(String type, String name) {  
		        this.type = type;  
		        this.name = name;  
		    }

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}  
	 }
}
