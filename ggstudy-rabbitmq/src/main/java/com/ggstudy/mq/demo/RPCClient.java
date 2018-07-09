package com.ggstudy.mq.demo;

import java.util.UUID;

import com.ggstudy.mq.model.ConnectPool;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class RPCClient {

	private Channel channel;
	private String requestQueueName = "rpc_queue";
	private String replyQueueName;
	private QueueingConsumer consumer;

	public RPCClient() throws Exception {
		Connection conn = ConnectPool.getConn();
		channel = conn.createChannel();
		replyQueueName = channel.queueDeclare().getQueue();
		consumer = new QueueingConsumer(channel);
		channel.basicConsume(replyQueueName, true, consumer);
	}

	public String call(String message) throws Exception {
		String response = null;
		String corrId = UUID.randomUUID().toString();

		BasicProperties props = new BasicProperties.Builder().correlationId(corrId).replyTo(replyQueueName).build();

		channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			if (delivery.getProperties().getCorrelationId().equals(corrId)) {
				response = new String(delivery.getBody(), "UTF-8");
				break;
			}
		}
		return response;
	}

	public static void main(String[] argv) {
		RPCClient rpcClient = null;
		String response = null;
		try {
			rpcClient = new RPCClient();

			System.out.println(" [RPCClient] Requesting fib(30)");
			response = rpcClient.call("30");
			System.out.println(" [RPCClient] Got '" + response + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
