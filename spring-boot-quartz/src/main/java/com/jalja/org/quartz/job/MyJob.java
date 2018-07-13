package com.jalja.org.quartz.job;

import javax.annotation.PostConstruct;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jalja.org.quartz.service.MyService;

@Component
public class MyJob implements Job{
    @Autowired
	private MyService myService;
    
    @PostConstruct
	private void init() {
		System.out.println("加载 MyJob:"+myService);
	}
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		this.myService.myTest();
	}
}
