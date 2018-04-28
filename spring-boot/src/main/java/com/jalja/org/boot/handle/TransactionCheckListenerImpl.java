package com.jalja.org.boot.handle;

import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.common.message.MessageExt;

@Component
public class TransactionCheckListenerImpl implements TransactionCheckListener{

	@Override
	public LocalTransactionState checkLocalTransactionState(MessageExt msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
