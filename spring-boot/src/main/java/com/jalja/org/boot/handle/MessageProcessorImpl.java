package com.jalja.org.boot.handle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;

@Component
public class MessageProcessorImpl  implements MessageListenerConcurrently{

	public static final Logger LOGGER = LoggerFactory.getLogger(MessageProcessorImpl.class);
	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		 LOGGER.info(Thread.currentThread().getName() + " Receive New Messages: " + msgs);
         MessageExt msg = msgs.get(0);
         LOGGER.info("消息内容："+new String(msg.getBody()));
         return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}
