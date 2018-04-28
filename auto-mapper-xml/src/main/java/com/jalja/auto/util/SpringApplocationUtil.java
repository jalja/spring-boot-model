package com.jalja.auto.util;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jalja.auto.config.FreemarkConfig;
import com.jalja.auto.config.MapperProperties;
import com.jalja.auto.db.TableInfoService;
import com.jalja.auto.model.TableInfo;

import freemarker.template.Template;

public class SpringApplocationUtil {

	public static void create() throws Exception {
		AnnotationConfigApplicationContext 
	    context=new AnnotationConfigApplicationContext("com.jalja.auto");
		MapperProperties  mapper= (MapperProperties) context.getBean("mapperProperties");
		TableInfoService tableInfoService =(TableInfoService) context.getBean("tableInfoService");
		List<TableInfo> tables=tableInfoService.getTableInfo(mapper.getDbName(), mapper.getTableName());
		
		//===生产实体bean================
		MyEntityUtils t = new MyEntityUtils(mapper.getPackageName(),mapper.getTableName(),mapper.getCreatePath());
		t.setParameterClass(mapper.getParameterClass());
		t.tableToEntity(tables);
		
		//================dao================
		FreemarkConfig freemarkConfig= context.getBean(FreemarkConfig.class);
		Template template= freemarkConfig.getTemplate();
		freemarkConfig.printFile(template, tables);
	}
	
	
	
}
