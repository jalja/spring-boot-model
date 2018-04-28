package com.jalja.org.boot.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.jalja.org.boot.mapper.TbAccountMapper;
import com.jalja.org.boot.model.TbAccount;
import com.jalja.org.boot.model.TbAccountExample;
import com.jalja.org.boot.model.TbAccountExample.Criteria;
import com.jalja.org.boot.model.vo.TransferAccount;

@Service
public class AccountService {
	@Autowired
	private TbAccountMapper tbAccountMapper;
	@Autowired
	private LogsService logsService;
	@Autowired
	private RocketMqService rocketMqService;
	
	private static final Logger logger=LoggerFactory.getLogger(AccountService.class);
	public boolean transferAccounts(String accountNo,String incAccountNo,BigDecimal money) {
		TransferAccount ta=new TransferAccount();
		ta.setAccountNo(accountNo);
		ta.setIncAccountNo(incAccountNo);
		ta.setMoney(money);
		String json=JSONObject.toJSONString(ta);
		return rocketMqService.sendTransactionMsg(json,UUID.randomUUID().toString());
	}
	
	
	@Transactional
	public void balance(Integer type,TransferAccount ta) throws RuntimeException{
		TbAccountExample example=new TbAccountExample();
		Criteria criteria=example.createCriteria();
		criteria.andAccountNoEqualTo(type==0?ta.getAccountNo():ta.getIncAccountNo());
		List<TbAccount>accounts=tbAccountMapper.selectByExample(example);
		if(accounts==null || accounts.isEmpty()) {
			throw new RuntimeException("该账户不存在");
		}
		TbAccount account=accounts.get(0);
		account.setCreateTime(new Date());
		BigDecimal balance=accounts.get(0).getBalance();
		if(type==0) {
			if(ta.getMoney().compareTo(balance)> BigDecimal.ZERO.intValue()) {
				throw new RuntimeException("该账户余额不足");
			}
			logger.info("账户：["+ta.getAccountNo()+"] 转入账户["+ta.getIncAccountNo()+"] 金额：["+ta.getMoney()+"]");
			logsService.addLogs("账户：["+ta.getAccountNo()+"] 转入账户["+ta.getIncAccountNo()+"] 金额：["+ta.getMoney()+"]");
			account.setAccountNo(ta.getAccountNo());
			account.setBalance(balance.subtract(ta.getMoney()));
		}
		if(type==1) {
			account.setAccountNo(ta.getIncAccountNo());
			account.setBalance(balance.add(ta.getMoney()));
			logger.info("账户：["+ta.getIncAccountNo()+"] 收到账户["+ta.getAccountNo()+"] 金额：["+ta.getMoney()+"]");
			logsService.addLogs("账户：["+ta.getIncAccountNo()+"] 收到账户["+ta.getAccountNo()+"] 金额：["+ta.getMoney()+"]");
		}
		account.setCreateTime(new Date());
		tbAccountMapper.updateByExampleSelective(account,example);
	}

}
