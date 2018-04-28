package com.jalja.auto.model;

public class MapperBean {
	private String propertyKey;
	private String propertyValue;
	public String getPropertyKey() {
		return propertyKey;
	}
	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	@Override
	public String toString() {
		return "MapperBean [propertyKey=" + propertyKey + ", propertyValue=" + propertyValue + "]";
	}
	
}
