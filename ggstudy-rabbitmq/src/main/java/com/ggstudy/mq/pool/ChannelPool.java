package com.ggstudy.mq.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.ggstudy.mq.model.ConnectionAndChannels;
import com.rabbitmq.client.Channel;

public class ChannelPool extends Pool<Channel> {

	public ChannelPool(GenericObjectPoolConfig poolConfig, ConnectionAndChannels cac) {
		super(poolConfig, new ChannelPooledObjectFactory(cac));
	}

	private static class ChannelPooledObjectFactory extends BasePooledObjectFactory<Channel> {
		ConnectionAndChannels cac = null;

		public ChannelPooledObjectFactory(ConnectionAndChannels cac) {
			this.cac = cac;
		}

		@Override
		public Channel create() throws Exception {
			// TODO 这里没这么简单(初始化一个ConnectionAndChannels还伴随着初始化其中的channel，有待进一步考虑)
			Channel c=cac.getConnection().createChannel();
			c.exchangeDeclare(cac.getExchange(), cac.getExchangeType());
			return c;
		}

		@Override
		public PooledObject<Channel> wrap(Channel obj) {
			return new DefaultPooledObject<Channel>(obj);
		}

		@Override
		public void destroyObject(PooledObject<Channel> p) throws Exception {
			final Channel channel = p.getObject();
			if (channel != null)
				channel.close();
		}
	}

}
