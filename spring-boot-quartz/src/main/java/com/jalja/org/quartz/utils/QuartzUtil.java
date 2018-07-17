package com.jalja.org.quartz.utils;

import java.util.ArrayList;
import java.util.List;

import com.jalja.org.quartz.job.JobBean;

public class QuartzUtil {
	private final static List<JobBean> jobBens=new ArrayList<>();
	
	public static void add(JobBean ben) {
		jobBens.add(ben);
	}
	public static List<JobBean> getJobBeans(){
		return jobBens;
	}
	public static <T> T[] listTurnArray(List<T> ts) {
		T[] s=(T[]) ts.toArray();
		return s;
	}
}
