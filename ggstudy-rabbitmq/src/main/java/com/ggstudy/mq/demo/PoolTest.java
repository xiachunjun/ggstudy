package com.ggstudy.mq.demo;

import java.io.IOException;

import com.ggstudy.mq.model.ConnectionAndChannels;
import com.ggstudy.mq.model.ConnectionAndChannelsInfo;
import com.ggstudy.mq.model.ConnectionPoolConfig;
import com.ggstudy.mq.pool.ConnectionPool;
import com.rabbitmq.client.Channel;

public class PoolTest {
	static ConnectionAndChannelsInfo cacInfo = new ConnectionAndChannelsInfo();
	static{
		cacInfo.setHost("10.214.168.134");
	}
	static ConnectionPool pool = new ConnectionPool(new ConnectionPoolConfig(), cacInfo);
	public static void main(String[] args) {
		
		ConnectionAndChannels cac = pool.getResource();
		
		Channel c = cac.getChannel();
		cac.basicPublish("s");
		cac.returnChannel(c);
		pool.returnResource(cac);
	}
	public static void main2(String[] args) {
		ConnectionAndChannels cac = pool.getResource();
		Channel c = cac.getChannel();
		//c.basicConsume(queue, autoAck, callback)
		cac.basicPublish("s");
		System.out.println(c);
		cac.returnChannel(c);
		try {
			pool.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
