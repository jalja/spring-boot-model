package com.jalja.org.quartz.config;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jalja.org.quartz.job.MyJob;

@Configuration
@ComponentScan(basePackages= {"com.jalja.org.quartz.*"})
public class MyQuartzConfig {
	@Autowired
	private MyJob myJob;
	
	
	@Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(myJob.getClass()).withIdentity("MyJob","MyGroup").build();
    }
	@Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().withIdentity("My-tr","MyGroup").withSchedule(scheduleBuilder).build();
    }
	@Bean
	public Scheduler getScheduler2() throws Exception {
		 Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler(); 
		 scheduler.start();
		 Date data=scheduler.scheduleJob(uploadTaskDetail(),uploadTaskTrigger());
		 return scheduler;
	}
}
