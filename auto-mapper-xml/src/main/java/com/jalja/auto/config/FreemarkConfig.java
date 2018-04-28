package com.jalja.auto.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jalja.auto.db.TableInfoService;
import com.jalja.auto.model.MapperBean;
import com.jalja.auto.model.TableInfo;
import com.jalja.auto.util.StringUtil;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class FreemarkConfig {
	@Autowired
	private MapperProperties mapperProperties;
	@Autowired
	private TableInfoService tableInfoService;
	
	public Template getTemplate() {
	    Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
	    Template temp=null;
	    String path = System.getProperty("user.dir")+"\\src\\main\\resources";
	    try {
	    	TemplateLoader loader=new FileTemplateLoader(new File(path));
	    	cfg.setTemplateLoader(loader);
			temp = cfg.getTemplate(mapperProperties.getTemplat());
		} catch (IOException e) {
			e.printStackTrace();
		}
	    System.out.println(mapperProperties.getTemplat());
	    return temp;
	}
	
	 public void printClose(Template template,List<TableInfo> list) throws Exception {
	    Map<String,Object> map=getMap(list);
        template.process(map, new PrintWriter(System.out));
	  }
	 public void printFile(Template temp,List<TableInfo> list) throws Exception {
		Map<String,Object> map=getMap(list);
        Writer writer=new FileWriter(new File(mapperProperties.getCreatePath()+mapperProperties.getTableName()+"_sql.xml"));
        temp.process(map,writer);
        writer.close();
	  }
	 private Map<String,Object> getMap(List<TableInfo> list) {
	    Map<String,Object> map=new HashMap<String, Object>();
        map.put("namespace", mapperProperties.getNamespace());
        map.put("parameterClass",mapperProperties.getParameterClass());
        map.put("resultClass", mapperProperties.getResultClass());
        map.put("tableName", mapperProperties.getTableName());
        List<MapperBean> beans=tableInfoService.getMapperBean(list);
        map.put("list", beans);
        map.put("selectSql",StringUtil.getSelectSql(beans));
        return map;
	 }
}
