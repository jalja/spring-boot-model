package com.jalja.auto.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.jalja.auto.model.TableInfo;

public class MyEntityUtils {
	    private String tablename = "";
	    private String packageName;
	    private String path;
	    private String[] colnames;
	    private String[] colTypes;
	    private int[] colSizes; 
	    private int[] colScale;
	    private String[] remarks;
	    private boolean importUtil = true;
	    private boolean importSql = false;
	    private boolean importMath = false;
	    private String parameterClass;
	    
	    
	    public MyEntityUtils(String packageName,String tablename,String path) {
			super();
			this.tablename = tablename;
			this.packageName = packageName;
			this.path = path;
		}
	    
		public String getParameterClass() {
			return parameterClass;
		}

		public void setParameterClass(String parameterClass) {
			this.parameterClass = parameterClass;
		}

		public void tableToEntity(List<TableInfo> list ) {
        int size =list.size();
        colnames = new String[size];
        colTypes = new String[size];
        colSizes = new int[size];
        colScale = new int[size];
        remarks=new String[size];
        for(int i = 0; i <list.size(); i++) {
    	    colnames[i] = list.get(i).getName().toLowerCase();
            colTypes[i] = list.get(i).getType().toLowerCase();
            remarks[i]=list.get(i).getRemork();
/*	            colScale[i] = rsmd.getScale(i + 1);*/
            if ("datetime".equals(colTypes[i])) {
                importUtil = true;
            }
            if ("image".equals(colTypes[i]) || "text".equals(colTypes[i])) {
                importSql = true;
            }
            if(colScale[i]>0){
                importMath = true;
            }
            colSizes[i] =0;
        }
        String content = parse(colnames, colTypes, colSizes);
        try {
            FileWriter fw = new FileWriter(path+StringUtil.updateByClassstr(tablename) + ".java");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(content);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	        
	    }
	
    private String parse(String[] colNames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer("package "+packageName+";");
       
        sb.append("\r\nimport com.zuche.framework.dao.util.QueryCond;\r\n");
        sb.append("\r\nimport com.zuche.framework.annotation.IbatisAliasConfig;\r\n");
        if (importUtil) {
            sb.append("import java.util.Date;\r\n");
        }
        if (importSql) {
            sb.append("import java.sql.*;\r\n\r\n");
        }
        if(importMath){
            sb.append("import java.math.*;\r\n\r\n");
        }

        processColnames(sb);
        sb.append("@IbatisAliasConfig(alias = \""+parameterClass+"\")\r\n");
        sb.append("public class " + StringUtil.updateByClassstr(tablename) + " extends QueryCond {\r\n");
        processAllAttrs(sb);
        processAllMethod(sb);
        sb.append("}\r\n");
        return sb.toString();
 
    }

    private void processColnames(StringBuffer sb) {
        sb.append("\r\n/** " + tablename + "\r\n");
        String colsiz="";
        String colsca="";
        for (int i = 0; i < colnames.length; i++) {
            colsiz = colSizes[i]<=0? "" : (colScale[i]<=0? "("+colSizes[i]+")" : "("+colSizes[i]+","+colScale[i]+")");
            sb.append("\t" + colnames[i].toUpperCase() +"    "+colTypes[i].toUpperCase()+ colsiz+"\r\n");
            char[] ch = colnames[i].toCharArray();
            char c ='a';
            if(ch.length>3){
                for(int j=0;j <ch.length; j++){
                    c = ch[j];
                    if(c == '_'){
                        if (ch[j+1]>= 'a' && ch[j+1] <= 'z') {
                            ch[j+1]=(char) (ch[j+1]-32);
                        }
                    }
                }
            }
            String str = new String(ch);
            colnames[i] = str.replaceAll("_", "");
        }
        sb.append("*/\r\n");
    }
    /**
     * 
     * 
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < colnames.length; i++) {
            sb.append("\tpublic void set" + initcap(colnames[i]) + "("
                    + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " " + colnames[i]
                    + "){\r\n");
            sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
 
            sb.append("\tpublic " + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " get"
                    + initcap(colnames[i]) + "(){\r\n");
            sb.append("\t\treturn " + colnames[i] + ";\r\n");
            sb.append("\t}\r\n");
        }
    }
 
    private void processAllAttrs(StringBuffer sb) {
        sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");
        for (int i = 0; i < colnames.length; i++) {
        	sb.append("/**"+remarks[i]+" **/\r\n");
            sb.append("\tprivate " + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " "
                    + colnames[i] + ";\r\n");
        }
        sb.append("\r\n");
    }
 
  
    private String initcap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
 
    /**
     * Oracle
     * @param sqlType
     * @param scale
     * @return
     */
    private String oracleSqlType2JavaType(String sqlType, int scale,int size) {
        if (sqlType.equals("int") || 
        	sqlType.equals("tinyint") || 
        	sqlType.equals("smallint")) {
            return "Integer";
        } else if (sqlType.equals("long") ||sqlType.equals("bigint")) {
            return "Long";
        } else if (sqlType.equals("float")
                || sqlType.equals("float precision")
                || sqlType.equals("double")
                || sqlType.equals("double precision")
                ) {
            return "BigDecimal";
        }else if (sqlType.equals("number")
                ||sqlType.equals("decimal")
                || sqlType.equals("numeric")
                || sqlType.equals("real")) {
            return scale==0? (size<10? "Integer" : "Long") : "BigDecimal";
        }else if (sqlType.equals("varchar")
                || sqlType.equals("varchar2")
                || sqlType.equals("char")
                || sqlType.equals("nvarchar")
                || sqlType.equals("nchar")) {
            return "String";
        } else if (sqlType.equals("datetime")
                || sqlType.equals("date")
                || sqlType.equals("timestamp")) {
            return "Date";
        }
        return null;
    }
}
