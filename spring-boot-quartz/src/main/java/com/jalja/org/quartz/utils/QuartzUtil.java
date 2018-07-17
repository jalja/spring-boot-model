package com.jalja.org.quartz.utils;

import java.util.ArrayList;
import java.util.List;



public class QuartzUtil {
	
	public static <T> T[] listTurnArray(List<T> ts) {
		T[] s=(T[]) ts.toArray();
		return s;
	}
}
