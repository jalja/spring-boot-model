package com.jalja.org.quartz.job;



import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jalja.org.quartz.service.MyService;

@Component
@Scope(value=BeanDefinition.SCOPE_PROTOTYPE)
public class MyJob implements Job{
	
	private static final Logger logger= LoggerFactory.getLogger(MyJob.class);
	
    @Autowired
	private MyService myService;
    
 
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		this.myService.myTest();
	}
}
