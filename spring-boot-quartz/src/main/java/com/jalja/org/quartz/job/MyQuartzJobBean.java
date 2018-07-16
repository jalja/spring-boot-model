package com.jalja.org.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class MyQuartzJobBean extends QuartzJobBean {
	private static final Logger logger= LoggerFactory.getLogger(MyQuartzJobBean.class);
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("MyQuartzJobBean");
	}

}
