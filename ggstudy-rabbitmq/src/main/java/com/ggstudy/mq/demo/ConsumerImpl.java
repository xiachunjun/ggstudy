package com.ggstudy.mq.demo;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ConsumerImpl extends DefaultConsumer {

	public ConsumerImpl(Channel channel) {
		super(channel);
	}
	
	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
		String message = new String(body, "UTF-8");
		System.out.println(this);
		System.out.println(" [ConsumerImpl] Received '" + message + "'");
		try {
			doWork(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" [ConsumerImpl] Done");
		super.getChannel().basicAck(envelope.getDeliveryTag(), true);// 消息确认
	}
	
	private static void doWork(String task) throws InterruptedException {
		for (char ch : task.toCharArray()) {
			if (ch == '.')
				Thread.sleep(1000);
		}
	}

}
