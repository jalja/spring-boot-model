package com.jalja.org.boot.handle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.jalja.org.boot.model.vo.TransferAccount;
import com.jalja.org.boot.service.AccountService;
@Component
public class MessageTrProcessorImpl implements MessageListenerConcurrently{

	public static final Logger logger = LoggerFactory.getLogger(MessageProcessorImpl.class);
	@Autowired
	private AccountService accountService;
	
	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		 if(msgs==null || msgs.isEmpty()) {
			 return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		 }
		 logger.info("List<MessageExt> :"+msgs+"  context: "+context);
		 MessageExt msg = msgs.get(0);
		 
		 logger.info("消费接受的消息内容："+new String(msg.getBody()));
		 String jsonMsg=new String(msg.getBody());
         TransferAccount ta=JSONObject.parseObject(jsonMsg, TransferAccount.class);
         try {
        	 accountService.balance(1, ta);
        	 if(msg.getReconsumeTimes()>2) {
        		 logger.info("已经重试了2次，不在重试==》  账户：["+ta.getIncAccountNo()+"] 收到账户["+ta.getAccountNo()+"] 金额：["+ta.getMoney()+"]");
        		 return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        	 }
        	 int m=1/0;
        	 return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		} catch (RuntimeException e) {
			logger.info("消息消费失败==》 开始重试");
			e.printStackTrace();
			return ConsumeConcurrentlyStatus.RECONSUME_LATER;
		}  
	}
}