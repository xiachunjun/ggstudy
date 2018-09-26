package com.ggstudy.mq.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.ggstudy.mq.model.ConnectPool;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

public class Sender {
	public static final String QUEUE_NAME = "queue_name";
	public static final String EXCHANGE_NAME = "exchange_direct";

	public static void main(String[] args) {
		Sender s = new Sender();
		for(int i=0;i<10;i++){
			s.sendMsg("aa"+i);
		}
	}

	public void exchangeSend(String... strings) {
		try {
			Connection conn = ConnectPool.getConn();
			Channel channel = conn.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, "direct");
//			channel.exchangeDeclare(EXCHANGE_NAME, "topic");
			String message = getMessage(strings);
			channel.basicPublish(EXCHANGE_NAME, "111", null, message.getBytes());
			System.out.println(" [x] 发送 '" + message + "'");
			channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMsg(String... strings) {
		try {
			Connection conn = ConnectPool.getConn();
			Channel channel = conn.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = getMessage(strings);
			channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			System.out.println(" [x] 发送 '" + message + "'");
			channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getMessage(String[] strings) {
		if (strings.length < 1)
			return "Hello World!";
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter) {
		int length = strings.length;
		if (length == 0)
			return "";
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}
}
