package com.jalja.org.quartz.config;






import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import com.jalja.org.quartz.job.MyJob;

@Configuration
public class MyQuartzConfig {
    
	@Bean
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
	}
}
