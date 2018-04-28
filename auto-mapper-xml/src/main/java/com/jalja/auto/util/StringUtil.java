package com.jalja.auto.util;


import java.util.List;

import com.jalja.auto.model.MapperBean;


public class StringUtil {
	public static String updateByClassstr(String str) { 
		 str=updateByFieldstr(str)+"Bean";
		 return upperCase(str).substring(1, str.length());
	 }
	
	public static String updateByFieldstr(String str) { 
		 if(str.indexOf("_")==-1) {
			 return upperCase(str);
		 }
		 String [] strs=str.split("_");
		 StringBuffer sb=new StringBuffer(strs[0]);
		 for(int i=1;i<strs.length;i++) {
			 sb.append(upperCase(strs[i]));
		 }
		 return sb.toString();
	 }
	 private static String upperCase(String str) {  
		    char[] ch = str.toCharArray();  
		    if (ch[0] >= 'a' && ch[0] <= 'z') {  
		        ch[0] = (char) (ch[0] - 32);  
		    }
		    return new String(ch);  
	}
	 
	 public static String getSelectSql(List<MapperBean> beans) {
		 StringBuffer sb=new StringBuffer();
		 for(MapperBean bean:beans) {
			 sb.append(bean.getPropertyKey()+" "+bean.getPropertyValue() +",");
		 }
		 return sb.toString().substring(0,sb.toString().length()-1);
	 } 
}
