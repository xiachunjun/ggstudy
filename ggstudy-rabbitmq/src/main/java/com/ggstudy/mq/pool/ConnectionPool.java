package com.ggstudy.mq.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.ggstudy.mq.model.ConnectionAndChannels;
import com.ggstudy.mq.model.ConnectionAndChannelsInfo;

public class ConnectionPool extends Pool<ConnectionAndChannels> {

	public ConnectionPool(GenericObjectPoolConfig poolConfig, ConnectionAndChannelsInfo cacInfo) {
		super(poolConfig, new ConnectionPooledObjectFactory(cacInfo));
	}

	private static class ConnectionPooledObjectFactory extends BasePooledObjectFactory<ConnectionAndChannels> {
		ConnectionAndChannelsInfo cacInfo = null;

		public ConnectionPooledObjectFactory(ConnectionAndChannelsInfo cacInfo) {
			this.cacInfo = cacInfo;
		}

		@Override
		public ConnectionAndChannels create() throws Exception {
			// TODO 这里没这么简单(初始化一个ConnectionAndChannels还伴随着初始化其中的channel，有待进一步考虑)
			return new ConnectionAndChannels(this.cacInfo);
		}

		@Override
		public PooledObject<ConnectionAndChannels> wrap(ConnectionAndChannels obj) {
			return new DefaultPooledObject<ConnectionAndChannels>(obj);
		}

		@Override
		public void destroyObject(PooledObject<ConnectionAndChannels> p) throws Exception {
			final ConnectionAndChannels cac = p.getObject();
			if (cac != null)
				cac.close();
		}

	}

}
