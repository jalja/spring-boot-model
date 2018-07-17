package com.jalja.org.quartz.config;

import org.quartz.CronTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import com.jalja.org.quartz.job.MyQuartzJobBean;

@Configuration
public class UserQuartzConfig {
	@Bean
	public MethodInvokingJobDetailFactoryBean getMethodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean invokingJobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
		invokingJobDetailFactoryBean.setTargetClass(MyQuartzJobBean.class);
		invokingJobDetailFactoryBean.setTargetMethod("addTest");
		invokingJobDetailFactoryBean.setName("my_Job1");
		invokingJobDetailFactoryBean.setGroup("my_group1");
		return invokingJobDetailFactoryBean;
	}
	/*@Bean
	public CronTrigger getCronTrigger() {
		CronTriggerFactoryBean crBean=new CronTriggerFactoryBean();
		crBean.setName("my_cro");
		crBean.setGroup("my_group");
		crBean.setJobDetail(getMethodInvokingJobDetailFactoryBean().getObject());
		crBean.setCronExpression("0/3 * * * * ?");
		return crBean.getObject();
	}*/
}
