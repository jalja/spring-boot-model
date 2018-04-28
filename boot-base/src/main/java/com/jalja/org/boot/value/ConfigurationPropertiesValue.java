package com.jalja.org.boot.value;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/** 
 * @ConfigurationProperties  prefix = "spring.datasource"  属性必须提供 set 
 * 1.5.2版本后locations属性无法使用
 * @author XL
 *
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class ConfigurationPropertiesValue {

	private String type;
	
	private List<String> url;
	
	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void showValue() {
		System.out.println("@Value 获取 type:"+type);
		System.out.println("@Value 获取List :"+url);
		
	}

}
