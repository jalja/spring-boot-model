package com.jalja.org.quartz.config;





import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.alibaba.druid.pool.DruidDataSource;
import com.jalja.org.quartz.job.AdaptableJobFactory;
import com.jalja.org.quartz.job.MyJob;



@Configuration
public class MyQuartzConfig {
    @Autowired
	private AdaptableJobFactory adaptableJobFactory;
    
    @Autowired
    private DruidDataSource druidDataSource;
    
/*	@Bean
	public JobDetailFactoryBean getJobDetailFactoryBean() {
		JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();
		jobDetailFactoryBean.setName("myJob");
		jobDetailFactoryBean.setGroup("myGroup");
		jobDetailFactoryBean.setJobClass(MyJob.class);
		jobDetailFactoryBean.setDurability(true);
		//jobDetailFactoryBean.setApplicationContextJobDataKey("applicationContext");
		return jobDetailFactoryBean;
	}
	@Bean
	public CronTriggerFactoryBean getCronTriggerFactoryBean() {
		CronTriggerFactoryBean crBean=new CronTriggerFactoryBean();
		crBean.setName("my_cron_tr");
		crBean.setGroup("myGroup");
		crBean.setJobDetail(getJobDetailFactoryBean().getObject());
		crBean.setCronExpression("0/3 * * * * ?");//     
		return crBean;
	}*/
	
	@Bean(name="jobDetailFactory")
	public MethodInvokingJobDetailFactoryBean getMethodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean invokingJobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
		//invokingJobDetailFactoryBean.setTargetObject(targetObject);
		//invokingJobDetailFactoryBean.setTargetMethod(targetMethod);
		invokingJobDetailFactoryBean.setName("my_Job");
		invokingJobDetailFactoryBean.setGroup("my_group");
		return invokingJobDetailFactoryBean;
	}
	@Bean(name="cron")
	public CronTriggerFactoryBean getgetCronTriggerFactoryBean2() {
		CronTriggerFactoryBean crBean=new CronTriggerFactoryBean();
		crBean.setName("my_cro");
		crBean.setGroup("my_group");
		//crBean.setJobDetail(jobDetail);
		//crBean.setCronExpression(cron);//    
		return crBean;
	}
	@Bean(name="schedulerFactory")
	public SchedulerFactoryBean getSchedulerFactoryBean2() {
		SchedulerFactoryBean scBean=new SchedulerFactoryBean();
		scBean.setJobFactory(adaptableJobFactory);
		scBean.setDataSource(druidDataSource);
		//CronTrigger [] cronTriggers=new  CronTrigger[] {getCronTriggerFactoryBean().getObject()};
		//scBean.setTriggers(cronTriggers);
		return scBean;
	}
	
	
	
	
	
	/*@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		SchedulerFactoryBean scBean=new SchedulerFactoryBean();
		scBean.setJobFactory(adaptableJobFactory);
		scBean.setDataSource(druidDataSource);
		CronTrigger [] cronTriggers=new  CronTrigger[] {getCronTriggerFactoryBean().getObject()};
		scBean.setTriggers(cronTriggers);
		scBean.setStartupDelay(2);
		return scBean;
	}*/
	

}
