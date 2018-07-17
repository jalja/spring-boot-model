package com.jalja.org.quartz.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import com.jalja.org.quartz.job.UserJob;
import com.jalja.org.quartz.job.UserJob2;

@Configuration
public class QuartzConfigration {
	    @Bean(name = "detailFactoryBean")
	    @Primary
	    public JobDetailFactoryBean getJobDetailFactoryBean() {
	    	JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();
	    	jobDetailFactoryBean.setName("AAA");
	    	jobDetailFactoryBean.setGroup("BBB");
	    	jobDetailFactoryBean.setJobClass(UserJob.class);
	    	jobDetailFactoryBean.setDurability(true);
			return jobDetailFactoryBean;
	    }
	 
	    @Bean(name = "cronTriggerBean")
	    @Primary
	    public CronTriggerFactoryBean cronTriggerBean(@Qualifier("detailFactoryBean")JobDetailFactoryBean detailFactoryBean){
	        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean ();
	        trigger.setJobDetail (detailFactoryBean.getObject ());
	        trigger.setCronExpression ("0/2 * * ? * *");//每5秒执行一次
	        return trigger;
	    }
	    
	    
	    @Bean(name = "detailFactoryBean2")
	    public JobDetailFactoryBean getJobDetailFactoryBean2() {
	    	JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();
	    	jobDetailFactoryBean.setName("CCC");
	    	jobDetailFactoryBean.setGroup("DDD");
	    	jobDetailFactoryBean.setJobClass(UserJob2.class);
	    	jobDetailFactoryBean.setDurability(true);
			return jobDetailFactoryBean;
	    }
	 
	    @Bean(name = "cronTriggerBean2")
	    public CronTriggerFactoryBean cronTriggerBean2(@Qualifier("detailFactoryBean2")JobDetailFactoryBean detailFactoryBean2){
	        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean ();
	        trigger.setJobDetail (detailFactoryBean2.getObject ());
	        trigger.setCronExpression ("0/5 * * ? * *");//每5秒执行一次
	        return trigger;
	    }

}
