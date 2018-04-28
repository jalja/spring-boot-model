package com.jalja.auto.model;

public class TableInfo {
	private String name;
	private String type;
	private String remork;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemork() {
		return remork;
	}
	public void setRemork(String remork) {
		this.remork = remork;
	}
	@Override
	public String toString() {
		return "TableInfo [name=" + name + ", type=" + type + ", remork=" + remork + "]";
	}
	
	
}
