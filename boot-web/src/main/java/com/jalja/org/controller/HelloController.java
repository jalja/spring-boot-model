package com.jalja.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello(String name) {
		int m=1/0;
		return name+"==>hello";
		
	}
}
