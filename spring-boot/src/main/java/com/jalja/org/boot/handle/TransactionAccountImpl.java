package com.jalja.org.boot.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.jalja.org.boot.model.vo.TransferAccount;
import com.jalja.org.boot.service.AccountService;

@Component
public class TransactionAccountImpl implements LocalTransactionExecuter{
	
	private static final Logger logger=LoggerFactory.getLogger(TransactionAccountImpl.class);
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
		 if(msg==null) {
			 return LocalTransactionState.COMMIT_MESSAGE;
		 }
		 logger.info("Message:"+msg+"  arg: "+arg);
		 String jsonMsg=new String(msg.getBody());
         TransferAccount ta=JSONObject.parseObject(jsonMsg, TransferAccount.class);
         try {
        	 accountService.balance(0, ta);
        	 return LocalTransactionState.COMMIT_MESSAGE;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return LocalTransactionState.ROLLBACK_MESSAGE;
		}
	}
}
