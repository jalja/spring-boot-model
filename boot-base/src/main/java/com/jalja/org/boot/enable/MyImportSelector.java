package com.jalja.org.boot.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import ch.qos.logback.classic.Logger;

/**
 * ImportSelector  将bean 加入spring容器
 * @author XL
 *
 */
public class MyImportSelector implements ImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		String [] strs=new String [] {"com.jalja.org.boot.enable.EnbleUser"};
		return strs;
	}

}
