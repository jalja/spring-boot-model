package com.jalja.org.throwable;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebException {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String error(Exception e) {
		return "系统异常，"+e.getMessage();
	}
}
