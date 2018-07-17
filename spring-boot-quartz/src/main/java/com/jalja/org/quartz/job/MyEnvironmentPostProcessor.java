package com.jalja.org.quartz.job;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import com.jalja.org.quartz.utils.QuartzUtil;
@Configuration
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor{
    private static final String classStr="quartz.job.class";
    private static final String JOB_NAME="quartz.job.name";
    private static final String JOB_GROUP="quartz.job.group";
    private static final String cron="quartz.trigger.cron";
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("job.properties"));
			PropertiesPropertySource source =new PropertiesPropertySource("my",properties);
			Map<String,Object> mpas=source.getSource();
			int length=mpas.size()/4;
			JobBean bean=null;
			JobDetail jobDetail=null;
			Trigger trigger=null;
			//for(int i=0;i<length;i++) {jobDetailFactoryBean.setDurability(true);
				 jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("A", "B").storeDurably(true).build();
				 trigger=TriggerBuilder.newTrigger().withIdentity("C", "B").withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();
				 bean=new JobBean(1, jobDetail, getCronTrigger());
				 QuartzUtil.add(bean);
			//}
			environment.getPropertySources().addLast(source);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
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
	public CronTrigger getCronTrigger() {
		CronTriggerFactoryBean crBean=new CronTriggerFactoryBean();
		crBean.setName("my_cron_tr");
		crBean.setGroup("myGroup");
		crBean.setJobDetail(getJobDetailFactoryBean().getObject());
		crBean.setCronExpression("0/3 * * * * ?");//     
		return crBean.getObject();
	}

}
