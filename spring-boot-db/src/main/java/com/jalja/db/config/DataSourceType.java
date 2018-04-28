package com.jalja.db.config;

public enum DataSourceType {
	 	read("read",0, "dataSourceRead"),  
	    write("write",-1, "dataSourceWriter");  
  
	    private String type; 
	    
	    private Integer index;
  
	    private String name;  
	  
	    DataSourceType(String type,Integer index, String name) {  
	        this.type = type;  
	        this.index = index; 
	        this.name = name;  
	    }

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
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
