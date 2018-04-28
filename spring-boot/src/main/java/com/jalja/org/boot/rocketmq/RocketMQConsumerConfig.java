package com.jalja.org.boot.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.jalja.org.boot.handle.MessageProcessorImpl;
import com.jalja.org.boot.handle.MessageTrProcessorImpl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketMQConsumerConfig {
	    public static final Logger LOGGER = LoggerFactory.getLogger(RocketMQConsumerConfig.class);
	    @Value("${rocketmq.consumer.namesrvAddr}")
	    private String namesrvAddr;
	    @Value("${rocketmq.consumer.groupName}")
	    private String groupName;
	    @Value("${rocketmq.consumer.topic}")
	    private String topic;
	    @Value("${rocketmq.consumer.tag}")
	    private String tag;
	    @Value("${rocketmq.consumer.consumeThreadMin}")
	    private int consumeThreadMin;
	    @Value("${rocketmq.consumer.consumeThreadMax}")
	    private int consumeThreadMax;
	    @Autowired
	    private MessageProcessorImpl messageProcessorImpl;

	    @Bean(name="rocketMQConsumer")
	    public DefaultMQPushConsumer getRocketMQConsumer() throws RuntimeException {
	        if (StringUtils.isBlank(groupName)){
	            throw new RuntimeException("groupName is null !!!");
	        }
	        if (StringUtils.isBlank(namesrvAddr)){
	            throw new RuntimeException("namesrvAddr is null !!!");
	        }
	        if (StringUtils.isBlank(topic)){
	            throw new RuntimeException("topic is null !!!");
	        }
	        if (StringUtils.isBlank(tag)){
	            throw new RuntimeException("tag is null !!!");
	        }
	        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
	        consumer.setNamesrvAddr(namesrvAddr);
	        consumer.setConsumeThreadMin(consumeThreadMin);
	        consumer.setConsumeThreadMax(consumeThreadMax);
	        consumer.registerMessageListener(messageProcessorImpl);
	        try {
	            consumer.subscribe(topic,this.tag);
	            consumer.start();
	            LOGGER.info("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr);
	        }catch (MQClientException e){
	            LOGGER.error("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr,e);
	            throw new RuntimeException(e);
	        }
	        return consumer;
	    }
	    
	    
	    @Value("${rocketmq.producer.group.account}")
	    private String groupAccount;
	    
	    
	    @Value("${rocketmq.producer.instance.account}")
	    private String instanceAccount;
	    
	    @Value("${rocketmq.producer.topic.account}")
	    private String topicAccount;
	    
	    @Autowired
	    private MessageTrProcessorImpl messageTrProcessorImpl;
	    
	    
	    @Bean(name="rocketMQTrConsumer")
	    public DefaultMQPushConsumer getRocketMQTrConsumer() throws RuntimeException {
	        if (StringUtils.isBlank(groupAccount)){
	            throw new RuntimeException("groupAccount is null !!!");
	        }
	        if (StringUtils.isBlank(namesrvAddr)){
	            throw new RuntimeException("namesrvAddr is null !!!");
	        }
	        if (StringUtils.isBlank(topicAccount)){
	            throw new RuntimeException("topic is null !!!");
	        }
	        if (StringUtils.isBlank(tag)){
	            throw new RuntimeException("tag is null !!!");
	        }
	        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupAccount);
	        consumer.setNamesrvAddr(namesrvAddr);
	        consumer.setConsumeThreadMin(consumeThreadMin);
	        consumer.setConsumeThreadMax(consumeThreadMax);
	        consumer.registerMessageListener(messageTrProcessorImpl);
	        try {
	            consumer.subscribe(topicAccount,this.tag);
	            consumer.start();
	            LOGGER.info("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupAccount,topicAccount,namesrvAddr);
	        }catch (MQClientException e){
	            LOGGER.error("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupAccount,topicAccount,namesrvAddr,e);
	            throw new RuntimeException(e);
	        }
	        return consumer;
	    }
	    

}
