package com.ggstudy.mq.topic;

import com.ggstudy.mq.model.ConnectPool;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicSender {

    public void sendMsg(String... strs) {
        try {
            Connection conn = ConnectPool.getConn();
            Channel channel = conn.createChannel();
            channel.exchangeDeclare("EXCHANGE_TOPIC","topic");
            String message = "消息内容";
            channel.basicPublish("EXCHANGE_TOPIC", "routingKey", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println("  发送 '" + message + "'");
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TopicSender().sendMsg("11111");
    }
}
