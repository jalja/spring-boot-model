package com.jalja.org.quartz.config;




import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.alibaba.druid.pool.DruidDataSource;
import com.jalja.org.quartz.job.AdaptableJobFactory;
import com.jalja.org.quartz.job.JobBean;
import com.jalja.org.quartz.utils.QuartzUtil;

@Configuration
public class SchedulerFactoryConfig {
	
	 @Autowired
	 private AdaptableJobFactory adaptableJobFactory;
	    
	 @Autowired
	 private DruidDataSource druidDataSource;
	 @Autowired
	 private CronTriggerFactoryBean cronTriggerFactoryBean;
	
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		SchedulerFactoryBean scBean=new SchedulerFactoryBean();
		scBean.setJobFactory(adaptableJobFactory);
		scBean.setDataSource(druidDataSource);
	//	CronTrigger ca=cronTriggerFactoryBean.getObject();
        List<JobBean> list=QuartzUtil.getJobBeans();
        CronTrigger [] fs=new CronTrigger[list.size()];
        for(int i=0;i<list.size();i++) {
        	fs[i]=(CronTrigger) list.get(i).getTrigger();
        }
		scBean.setTriggers(fs);
		scBean.setStartupDelay(2);
		return scBean;
	}
}
