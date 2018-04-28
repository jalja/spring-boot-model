package com.jalja.org.boot.service;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.jalja.org.boot.handle.TransactionAccountImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RocketMqService {
    @Autowired
    private DefaultMQProducer defaultMQProducer;
    @Autowired
    private TransactionMQProducer transactionMQProducer;
    @Autowired
    private TransactionAccountImpl transactionAccountImpl;
    @Autowired
    private TransactionCheckListener transactionCheckListener ;
    
    @Value("${rocketmq.producer.topic}")
    private String topicTest;
    @Value("${rocketmq.producer.topic.account}")
    private String topicAccount;
    
    @Value("${rocketmq.producer.tag}")
    private String tagTest;
    
    
    
    
    private static final Logger logger=LoggerFactory.getLogger(RocketMqService.class);
    
    public boolean sendMsg(String msg){
    	Message body = new Message(topicTest,tagTest,"OrderID061",msg.getBytes());
    	try {
    		SendResult result=defaultMQProducer.send(body);
    		logger.info("result:"+result);
    		return true;
    	}catch (Exception e) {
    		e.printStackTrace();
    		logger.error("消息发送失败。。。。。");
    		return false;
		}
    }
    
    /**
     * 发送事物消息
     * @param msg
     * @return
     */
    public boolean sendTransactionMsg(String msg,String key){
    	Message body = new Message(topicAccount,tagTest,key,msg.getBytes());
    	try {
    		transactionMQProducer.setTransactionCheckListener(transactionCheckListener);
    		SendResult result=transactionMQProducer.sendMessageInTransaction(body, transactionAccountImpl, null);
    		return true;
    	}catch (Exception e) {
    		e.printStackTrace();
    		logger.error("消息发送失败。。。。。");
    		return false;
		}
    }
    
}
