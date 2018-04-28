package com.jalja.auto.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jalja.auto.model.MapperBean;
import com.jalja.auto.model.TableInfo;
import com.jalja.auto.util.StringUtil;

@Service(value="tableInfoService")
public class TableInfoService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<TableInfo> getTableInfo(String dbName,String tableName){
		StringBuilder sb=new StringBuilder();
		sb.append("select column_name name,DATA_TYPE type,COLUMN_COMMENT remork");
		sb.append(" from information_schema.COLUMNS WHERE TABLE_SCHEMA='"+dbName+"' ");
		sb.append(" and table_name='"+tableName+"'");
		System.out.println(sb.toString());
		List<Map<String, Object>> listMap=jdbcTemplate.queryForList(sb.toString());
		if(listMap==null) {
			throw new RuntimeException("未查到数据");
		}
		 List<TableInfo> list=new ArrayList<TableInfo>();
		 TableInfo info=null;
		for(Map<String, Object> map:listMap) {
			info=new TableInfo();
			for(Map.Entry<String, Object> entry : map.entrySet()) { 
				if(entry.getKey().equals("name")) {
					info.setName(entry.getValue().toString());
				}
				if(entry.getKey().equals("remork")) {
					info.setRemork(entry.getValue()==null?"":entry.getValue().toString());
				}
				if(entry.getKey().equals("type")) {
					info.setType(entry.getValue()==null?"":entry.getValue().toString());
				}
			}
			list.add(info);
		}
		return list;
	}
	public  List<MapperBean> getMapperBean(List<TableInfo> list){
		 List<MapperBean> beans=new ArrayList<>();
		 MapperBean bean=null;
		 String st="";
		for(TableInfo tb:list) {
			st=tb.getName();
			bean=new MapperBean();
			 if(st.indexOf("_")!=-1) {
				 bean.setPropertyKey(st.trim());
				 bean.setPropertyValue(StringUtil.updateByFieldstr(st.trim()));
			 }else {
				 bean.setPropertyKey(st.trim());
				 bean.setPropertyValue(st.trim());
			 }
			 beans.add(bean);
		}
		return beans;
	 } 

}
