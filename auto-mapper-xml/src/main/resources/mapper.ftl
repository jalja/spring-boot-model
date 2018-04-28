<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE sqlMap PUBLIC "-//iBATIS.com//DTD SQL Map 2.0//EN" "http://ibatis.apache.org/dtd/sql-map-2.dtd">
<sqlMap namespace="${namespace}" >
  <sql id="loan_base_list" >
     ${selectSql}
  </sql>
  
  
 
     <sql id="where_base_list">
	<#if list?exists>  
    <#list list as ent>  
    <isNotEmpty prepend="and" property="${ent.propertyValue}" >
        ${ent.propertyKey}=#${ent.propertyValue}#
    </isNotEmpty>
   </#list>  
     </#if>   
      </sql>
     
  <!-- 根据条件查询多条记录 -->
  <select id="getList"  resultClass="${resultClass}" parameterClass="${parameterClass}" >
    select 
    <include refid="loan_base_list" />
    from ${tableName}
    where 1=1
    <include refid="where_base_list" />
  </select>
  
  
 <!--    
  <select id="selectByApplyId" resultClass="${resultClass}" parameterClass="long">
    select
    <include refid="loan_base_list" />
    from ${tableName}
    where apply_id=#applyId#
  </select>
 -->
    <!-- 根据条件ID查询1条记录 -->
  <select id="selectById" resultClass="${resultClass}" parameterClass="long">
    select
    <include refid="loan_base_list" />
    from ${tableName}
    where id=#id#
  </select>  
  
  <!-- 单条插入 -->
  <insert id="insert" parameterClass="${parameterClass}" >
    insert into ${tableName} 
    <dynamic prepend="(" >
    <#if list?exists>  
    <#list list as ent2>  
    <isNotEmpty prepend="," property="${ent2.propertyValue}" >
        ${ent2.propertyKey}
    </isNotEmpty>
   </#list>  
     </#if>
     )   
    </dynamic>
    
    values 
      <dynamic prepend="(" >
       <#if list?exists>  
        <#list list as ent3>  
	    <isNotEmpty prepend="," property="${ent3.propertyValue}" >
	        #${ent3.propertyValue}#
	    </isNotEmpty>
       </#list>  
         </#if>
          )
       </dynamic>          
     
  </insert>


  <sql id="update_where_base_list">
  <#if list?exists>  
    <#list list as ent4>  
	    <isNotEmpty prepend="," property="${ent4.propertyValue}" >
	        ${ent4.propertyKey} = #${ent4.propertyValue}#
	    </isNotEmpty>
   </#list>  
   </#if>  
  </sql>

<!--  
  <update id="updateByApplyId" parameterClass="${parameterClass}" >
    update  ${tableName}
    <dynamic prepend="SET" >
      <include refid="update_where_base_list" />
    </dynamic>
    where apply_id = #applyId#
  </update>
-->
   <!-- 修改根据id -->
  <update id="updateById" parameterClass="${parameterClass}" >
    update  ${tableName}
    <dynamic prepend="SET" >
      <include refid="update_where_base_list" />
    </dynamic>
    where id = #id#
  </update>

  
   <insert id="history" parameterClass="${parameterClass}">
		
	</insert>
</sqlMap>