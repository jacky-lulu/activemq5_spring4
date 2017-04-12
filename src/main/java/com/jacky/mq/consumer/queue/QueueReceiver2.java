package com.jacky.mq.consumer.queue;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
@Component
public class QueueReceiver2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("QueueReceiver2接收到消息:"+((TextMessage)message).getText());
            message.acknowledge();////手动向broker确认接收成功，如果发生异常，就不反回ack
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
