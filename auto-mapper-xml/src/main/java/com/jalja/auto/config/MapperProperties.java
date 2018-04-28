package com.jalja.auto.config;

import org.springframework.beans.factory.annotation.Value;

public class MapperProperties {
	@Value(value="${mapper.namespace}")
	private String namespace;
	
	@Value(value="${mapper.tableName}")
	private String tableName;
	
	@Value(value="${mapper.parameterClass}")
	private String parameterClass;
	
	@Value(value="${mapper.resultClass}")
	private String resultClass;
	
	@Value(value="${mapper.packageName}")
	private String packageName;
	
	@Value(value="${mapper.dbName}")
	private String dbName;
	@Value(value="${mapper.templat}")
	private String templat;

	@Value(value="${mapper.createPath}")
	private String createPath;
	
	
	public String getCreatePath() {
		return createPath;
	}

	public void setCreatePath(String createPath) {
		this.createPath = createPath;
	}

	public String getTemplat() {
		return templat;
	}

	public void setTemplat(String templat) {
		this.templat = templat;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getParameterClass() {
		return parameterClass;
	}

	public void setParameterClass(String parameterClass) {
		this.parameterClass = parameterClass;
	}

	public String getResultClass() {
		return resultClass;
	}

	public void setResultClass(String resultClass) {
		this.resultClass = resultClass;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
	
	
}
