package com.jalja.org.quartz.job;

import org.quartz.JobDetail;
import org.quartz.Trigger;

public class JobBean {
	private int number;
	private JobDetail jobDetail;
	private Trigger trigger;
	
	public JobBean(int number, JobDetail jobDetail, Trigger trigger) {
		super();
		this.number = number;
		this.jobDetail = jobDetail;
		this.trigger = trigger;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public JobDetail getJobDetail() {
		return jobDetail;
	}
	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}
	public Trigger getTrigger() {
		return trigger;
	}
	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
	
}
