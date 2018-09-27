package com.ggstudy.mq.topic;

import com.ggstudy.mq.demo.ConsumerImpl;
import com.ggstudy.mq.model.ConnectPool;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicReciver {


    public void exchangeRecv() {
        Connection conn = ConnectPool.getConn();
        final Channel channel;
        try {
            channel = conn.createChannel();
            channel.exchangeDeclare("EXCHANGE_TOPIC", "topic");
//            String queueName = channel.queueDeclare().getQueue();
            channel.queueDeclare("queue1",false,false,true,null);
            channel.queueDeclare("queue2",false,false,true,null);
            channel.queueDeclare("queue3",false,false,true,null);

            channel.queueBind("queue1", "EXCHANGE_TOPIC", "routingKey");
            channel.queueBind("queue2", "EXCHANGE_TOPIC", "routingKey");
            channel.queueBind("queue3", "EXCHANGE_TOPIC", "routingKey");
            channel.basicQos(1);// 预取1条消息
            Consumer consumer1 = new ConsumerImpl(channel);
            Consumer consumer2 = new ConsumerImpl(channel);
            Consumer consumer3 = new ConsumerImpl(channel);
            channel.basicConsume("queue1", false, consumer1);// 第二个参数false是不会自动确认消息，true自动确认
            channel.basicConsume("queue2", false, consumer2);// 第二个参数false是不会自动确认消息，true自动确认
            channel.basicConsume("queue3", false, consumer3);// 第二个参数false是不会自动确认消息，true自动确认
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TopicReciver().exchangeRecv();
    }
}
