package com.ggstudy.mq.demo;

import java.io.IOException;

import com.ggstudy.mq.model.ConnectPool;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receiver {
	public static final String QUEUE_NAME = "queue_name";
	public static final String EXCHANGE_NAME = "exchange_direct";

	public static void main(String[] args) {
		Receiver r = new Receiver();
		r.recv();
	}

	public void exchangeRecv() {
		Connection conn = ConnectPool.getConn();
		final Channel channel;
		try {
			channel = conn.createChannel();
			channel.exchangeDeclare(EXCHANGE_NAME, "direct");
			String queueName = channel.queueDeclare().getQueue();
			// QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.queueBind(queueName, EXCHANGE_NAME, "111");
			channel.basicQos(1);// 预取1条消息
			Consumer consumer = new ConsumerImpl(channel);
			channel.basicConsume(queueName, false, consumer);// 第二个参数false是不会自动确认消息，true自动确认
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void recv() {
		Connection conn = ConnectPool.getConn();
		final Channel channel;
		try {
			channel = conn.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			channel.basicQos(1);// 预取1条消息
			final Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println(this);
					System.out.println(" [x] Received '" + message + "'");
					try {
						doSomething(message);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(" [x] Done");
					channel.basicAck(envelope.getDeliveryTag(), true);// 消息确认
				}
			};
			channel.basicConsume(QUEUE_NAME, false, consumer);// 第二个参数false是不会自动确认消息，true自动确认
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void doSomething(String task) throws InterruptedException {
		for (char ch : task.toCharArray()) {
			if (ch == '.')
				Thread.sleep(1000);
		}
	}

}
