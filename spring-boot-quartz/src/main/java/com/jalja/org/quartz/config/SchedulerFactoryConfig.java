package com.jalja.org.quartz.config;






import javax.annotation.Resource;

import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import com.alibaba.druid.pool.DruidDataSource;
import com.jalja.org.quartz.job.AdaptableJobFactory;


public class SchedulerFactoryConfig {
	
	 @Autowired
	 private AdaptableJobFactory adaptableJobFactory;
	    
	 @Autowired
	 private DruidDataSource druidDataSource;
	 
	 @Resource(name="cronTriggerBean")
	 private CronTriggerFactoryBean cronTriggerBean;
	 
	 @Resource(name="cronTriggerBean2")
	 private CronTriggerFactoryBean cronTriggerBean2;
	
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		SchedulerFactoryBean scBean=new SchedulerFactoryBean();
		scBean.setJobFactory(adaptableJobFactory);
		scBean.setDataSource(druidDataSource);
        CronTrigger [] fs=new CronTrigger[] {cronTriggerBean.getObject(),cronTriggerBean2.getObject()};
		scBean.setTriggers(fs);
		scBean.setStartupDelay(2);
		return scBean;
	}
}
