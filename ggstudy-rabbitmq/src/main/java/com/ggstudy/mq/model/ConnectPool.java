package com.ggstudy.mq.model;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectPool {
	
	public static Connection getConn() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.214.168.134");
//		factory.setHost("localhost");
		factory.setUsername("admin");
		factory.setPassword("admin");
		factory.setPort(5672);
		factory.setConnectionTimeout(60000);
		factory.setHandshakeTimeout(60000);//设置TCP握手超时时间，解决网络不好时获取链接超时
		try {
			Connection connection = factory.newConnection();
			return connection;
			// channel = connection.createChannel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private ConnectPool() {
	}
}
