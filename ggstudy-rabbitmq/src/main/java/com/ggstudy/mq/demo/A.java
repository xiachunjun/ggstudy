package com.ggstudy.mq.demo;

import java.util.concurrent.TimeoutException;

import com.ggstudy.mq.model.ConnectPool;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class A {
	public static void main0(String[] args) {
		Sender s = new Sender();
		s.sendMsg("aaa");
		// for(int i=0;i<10;i++){
		// s.exchangeSend(1+"",".");
		// }
	}

	public static void main1(String[] args) {
		Receiver r = new Receiver();
		r.exchangeRecv();
	}

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws java.io.IOException {

		// 创建一个连接
		Connection connection = null;
		Channel channel = null;
		connection = ConnectPool.getConn();
		channel = connection.createChannel();
		// 创建一个频道
		// 指定一个队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// 发送的消息
		String message = "hello world!";
		// 往队列中发出一条消息
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		// 关闭频道和连接
		try {
			channel.close();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		connection.close();
	}
}
