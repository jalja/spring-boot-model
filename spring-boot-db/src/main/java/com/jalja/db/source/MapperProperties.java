package com.jalja.db.source;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mybatis.mapper")
public class MapperProperties {
	private String  aliasesPackage;
	private String  mapperScanner;
	private String mapperLocations;
	//是否读写分离 默认false
	private String isRead;
	//读数据源数量
	private Integer readNum=1;
	
	
	public Integer getReadNum() {
		return readNum;
	}
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
	
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public String getMapperLocations() {
		return mapperLocations;
	}
	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
	public String getAliasesPackage() {
		return aliasesPackage;
	}
	public void setAliasesPackage(String aliasesPackage) {
		this.aliasesPackage = aliasesPackage;
	}
	public String getMapperScanner() {
		return mapperScanner;
	}
	public void setMapperScanner(String mapperScanner) {
		this.mapperScanner = mapperScanner;
	}
	
	
}
