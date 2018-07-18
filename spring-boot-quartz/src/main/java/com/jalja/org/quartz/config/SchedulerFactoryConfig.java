package com.jalja.org.quartz.config;






import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import com.alibaba.druid.pool.DruidDataSource;
import com.jalja.org.quartz.job.AdaptableJobFactory;

@Configuration
public class SchedulerFactoryConfig {
	
	 @Autowired
	 private AdaptableJobFactory adaptableJobFactory;
	    
	 @Autowired
	 private DruidDataSource druidDataSource;
	 
	 @Autowired
	 @Qualifier("cronTriggerBean")
	 private CronTriggerFactoryBean cronTriggerBean;
	 
	 @Autowired
	 @Qualifier("cronTriggerBean2")
	 private CronTriggerFactoryBean cronTriggerBean2;
	
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		SchedulerFactoryBean scBean=new SchedulerFactoryBean();
		scBean.setConfigLocation(new ClassPathResource("quartz.properties",this.getClass().getClassLoader()));
		scBean.setJobFactory(adaptableJobFactory);
		scBean.setDataSource(druidDataSource);
        CronTrigger [] fs=new CronTrigger[] {cronTriggerBean.getObject(),cronTriggerBean2.getObject()};
		scBean.setTriggers(fs);
		scBean.setStartupDelay(2);
		return scBean;
	}
}
