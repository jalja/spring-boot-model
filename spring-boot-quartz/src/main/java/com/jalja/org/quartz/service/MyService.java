package com.jalja.org.quartz.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jalja.org.quartz.mapper.JaljaUserMapper;
import com.jalja.org.quartz.model.JaljaUser;
import com.jalja.org.quartz.model.JaljaUserExample;



@Service
public class MyService {
	
	private static final Logger logger= LoggerFactory.getLogger(MyService.class);
	@Autowired
	private JaljaUserMapper jaljaUserMapper;
	
	public void myTest() {
		JaljaUserExample example=new JaljaUserExample();
		List<JaljaUser> users=jaljaUserMapper.selectByExample(example);
		logger.info(JSON.toJSONString(users));
    }
}
