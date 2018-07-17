package com.jalja.org.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.jalja.org.quartz.service.MyService;
@Component
@DisallowConcurrentExecution
public class UserJob extends QuartzJobBean{
	private static final Logger logger= LoggerFactory.getLogger(UserJob.class);
	@Autowired
	private MyService myService;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		myService.myTest(this.getClass().getName());
	}

}
