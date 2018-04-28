package com.jalja.org.boot.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RocketMQProducerConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger(RocketMQProducerConfig.class);
    @Value("${rocketmq.producer.groupName}")
    private String groupName;
    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.producer.instanceName}")
    private String instanceName;
    @Value("${rocketmq.producer.maxMessageSize}")
    private int maxMessageSize ; //4M
    @Value("${rocketmq.producer.sendMsgTimeout}")
    private int sendMsgTimeout ;

    private DefaultMQProducer defaultMQProducer;
    
    private TransactionMQProducer  transactionMQProducer;
    
    @Primary
    @Bean(name = "defaultMQProducer")
    public DefaultMQProducer getRocketMQProducer() throws RuntimeException {
        if (StringUtils.isBlank(this.groupName)) {
            throw new RuntimeException("groupName is blank");
        }
        if (StringUtils.isBlank(this.namesrvAddr)) {
            throw new RuntimeException("nameServerAddr is blank");
        }
        if (StringUtils.isBlank(this.instanceName)){
            throw new RuntimeException("instanceName is blank");
        }

        defaultMQProducer = new DefaultMQProducer(this.groupName);
        defaultMQProducer.setNamesrvAddr(this.namesrvAddr);
        defaultMQProducer.setInstanceName(instanceName);
        defaultMQProducer.setMaxMessageSize(this.maxMessageSize);
        defaultMQProducer.setSendMsgTimeout(this.sendMsgTimeout);
        try {
        	defaultMQProducer.start();
            LOGGER.info(String.format("producer is start ! groupName:[%s],namesrvAddr:[%s]"
                    , this.groupName, this.namesrvAddr));
        } catch (MQClientException e) {
            LOGGER.error(String.format("producer is error {}"
                    , e.getMessage(),e));
            throw new RuntimeException(e);
        }
        return defaultMQProducer;
    }
    
    
    
    @Value("${rocketmq.producer.group.account}")
    private String groupAccount;
    
    
    @Value("${rocketmq.producer.instance.account}")
    private String instanceAccount;
    
    @Bean(name="transactionMQProducer")
    public TransactionMQProducer  getTransactionMQProducer() throws RuntimeException {
        if (StringUtils.isBlank(this.groupAccount)) {
            throw new RuntimeException("groupAccount is blank");
        }
        if (StringUtils.isBlank(this.namesrvAddr)) {
            throw new RuntimeException("nameServerAddr is blank");
        }
        if (StringUtils.isBlank(this.instanceAccount)){
            throw new RuntimeException("instanceAccount is blank");
        }
        transactionMQProducer = new TransactionMQProducer(this.instanceAccount);
        transactionMQProducer.setNamesrvAddr(this.namesrvAddr);
        transactionMQProducer.setInstanceName(instanceAccount);
        transactionMQProducer.setMaxMessageSize(this.maxMessageSize);
        transactionMQProducer.setSendMsgTimeout(this.sendMsgTimeout);
        try {
        	transactionMQProducer.start();
            LOGGER.info(String.format("producer is start ! groupName:[%s],namesrvAddr:[%s]" , this.instanceAccount, this.namesrvAddr));
        } catch (MQClientException e) {
            LOGGER.error(String.format("producer is error {}", e.getMessage(),e));
            throw new RuntimeException(e);
        }
        return transactionMQProducer;
    }
    
}
