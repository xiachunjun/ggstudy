package com.ggstudy.mq.demo;

import com.ggstudy.mq.model.ConnectPool;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class RPCServer {

	private static final String RPC_QUEUE_NAME = "rpc_queue";

	/**
	 * 逻辑：f(0)=0 f(1)=1 f(2)=f(0)+f(1) f(3)=f(2)+f(1) f(4)=f(3)+f(2)....
	 * 
	 * @param n
	 * @return
	 */
	private static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] argv) {
		Channel channel = null;
		try {
			Connection conn = ConnectPool.getConn();
			channel = conn.createChannel();

			channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);

			channel.basicQos(1);

			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

			System.out.println(" [RPCServer] Awaiting RPC requests");

			while (true) {
				String response = null;

				QueueingConsumer.Delivery delivery = consumer.nextDelivery();

				BasicProperties props = delivery.getProperties();
				BasicProperties replyProps = new BasicProperties.Builder().correlationId(props.getCorrelationId()).build();

				try {
					String message = new String(delivery.getBody(), "UTF-8");
					int n = Integer.parseInt(message);

					System.out.println(" [RPCServer] fib(" + message + ")");
					response = "" + fib(n);
				} catch (Exception e) {
					System.out.println(" [RPCServer] " + e.toString());
					response = "";
				} finally {
					channel.basicPublish("", props.getReplyTo(), replyProps, response.getBytes("UTF-8"));

					channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
