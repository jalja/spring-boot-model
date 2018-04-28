package com.jalja.org.boot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalja.org.boot.mapper.TbLogsMapper;
import com.jalja.org.boot.model.TbLogs;

@Service
public class LogsService {
	@Autowired
	private TbLogsMapper tbLogsMapper;
	
	public void addLogs(String msg) {
		TbLogs tbLogs=new TbLogs();
		tbLogs.setRemark(msg);
		tbLogs.setCreateTime(new Date());
		tbLogsMapper.insertSelective(tbLogs);
	}
}
