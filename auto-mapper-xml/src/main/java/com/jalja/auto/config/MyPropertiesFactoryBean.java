package com.jalja.auto.config;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyPropertiesFactoryBean extends PropertyPlaceholderConfigurer {
	
	private Properties props; 

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
                            throws BeansException {
    	try {
			props.load(MyPropertiesFactoryBean.class.getClassLoader().getResourceAsStream("application.properties"));
			createDir(props.getProperty("mapper.createPath"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        super.processProperties(beanFactoryToProcess, props);
        this.props = props;
    }

    public String getProperty(String key){
        return this.props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.props.getProperty(key, defaultValue);
    }

    public Object setProperty(String key, String value) {
        return this.props.setProperty(key, value);
    }
    private static void createDir(String destDirName) {  
        File dir = new File(destDirName);  
        if (dir.exists()) {  
        	return;
        }  
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }
        dir.mkdirs();

    }  
}
