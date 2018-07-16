package com.jalja.org.quartz;



import org.quartz.CronTrigger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.jalja.org.quartz.job.MyQuartzJobBean;



@SpringBootApplication
public class QuartzApplicationMain {

	public static void main(String[] args) throws Exception {
		 ConfigurableApplicationContext config= SpringApplication.run(QuartzApplicationMain.class, args);
		 MyQuartzJobBean job=config.getBean(MyQuartzJobBean.class);
		 MethodInvokingJobDetailFactoryBean jobFc= (MethodInvokingJobDetailFactoryBean) config.getBean("jobDetailFactory");
		 jobFc.setTargetObject(job);
		 jobFc.setTargetMethod("add");
		 CronTriggerFactoryBean corn=(CronTriggerFactoryBean) config.getBean("cron");
		 corn.setJobDetail(jobFc.getObject());
		 corn.setCronExpression("0/3 * * * * ?");    
		 
		 SchedulerFactoryBean sc=(SchedulerFactoryBean) config.getBean("schedulerFactory",corn.getObject());
		 CronTrigger [] cronTriggers=new  CronTrigger[] {corn.getObject()};
		 sc.setTriggers(cronTriggers);
		 
		 sc.start();
		 
	}
}
