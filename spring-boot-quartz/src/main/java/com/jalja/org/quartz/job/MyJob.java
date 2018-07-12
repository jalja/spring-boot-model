package com.jalja.org.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.jalja.org.quartz.service.MyService;

@Component
public class MyJob extends QuartzJobBean  {
	
    @Autowired
	private MyService myService;
    
	@Override
	protected void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {
		System.out.println("MyJob:"+jobContext);
		myService.myTest();
	}
}
