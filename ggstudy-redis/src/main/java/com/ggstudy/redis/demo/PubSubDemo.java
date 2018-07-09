package com.ggstudy.redis.demo;

import org.junit.Test;

import redis.clients.jedis.JedisPubSub;

public class PubSubDemo extends BaseDemo {

	// BinaryJedisPubSub
	@Test
	public void sub() {
		JedisPubSub jedisPubSub = new JedisPubSubImpl();
		//jedis.subscribe(jedisPubSub, "channel1", "channel2");//订阅指定的channel
		jedis.psubscribe(jedisPubSub, "a*");//定义正则匹配的channel
	}

	//@Test
	public void pub() {
		jedis.publish("ahannel1", "ssssssssss");
		jedis.publish("channel1", "ssssssssss");
	}

}

class JedisPubSubImpl extends JedisPubSub {
	public void onMessage(String channel, String message) {
		System.out.println("方法名：onMessage");
		System.out.println("参数:channel:" + channel + ",message:" + message);
	}

	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("方法名：onPMessage");
		System.out.println("参数:pattern:" + pattern + ",channel:" + channel + ",message:" + message);
	}

	public void onSubscribe(String channel, int subscribedChannels) {
		System.out.println("方法名：onSubscribe");
		System.out.println("参数:channel:" + channel + ",subscribedChannels:" + subscribedChannels);
	}

	public void onUnsubscribe(String channel, int subscribedChannels) {
		System.out.println("方法名：onUnsubscribe");
		System.out.println("参数:channel:" + channel + ",subscribedChannels:" + subscribedChannels);
	}

	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		System.out.println("方法名：onPUnsubscribe");
		System.out.println("参数:pattern:" + pattern + ",subscribedChannels:" + subscribedChannels);
	}

	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("方法名：onPSubscribe");
		System.out.println("参数:pattern:" + pattern + ",subscribedChannels:" + subscribedChannels);
	}
}
