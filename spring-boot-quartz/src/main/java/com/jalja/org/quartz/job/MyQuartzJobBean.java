package com.jalja.org.quartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyQuartzJobBean {
	private static final Logger logger= LoggerFactory.getLogger(MyQuartzJobBean.class);
	
	public void addTest() {
		logger.info("add==>");
	}

}
