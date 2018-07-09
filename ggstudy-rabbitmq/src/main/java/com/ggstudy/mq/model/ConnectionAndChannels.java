package com.ggstudy.mq.model;

import java.io.IOException;

import com.ggstudy.mq.pool.ChannelPool;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionAndChannels {
	public static final String CONNECT_DEFAULT_HOST = "localhost";
	public static final int CONNECT_DEFAULT_PORT = 5672;
	public static final String CHANNEL_DEFAULT_EXCHANGE = "default_exchange";
	public static final String CHANNEL_DEFAULT_EXCHANGE_TYPE = "fanout";
	public static final String CHANNEL_DEFAULT_ROUTINGKEY = "";
	
	final Object initChannelPoolLock = new Object();
	private ConnectionAndChannelsInfo cacInfo = null;
	private Connection connection;
	private ChannelPool channelPool;
	
	private String host = CONNECT_DEFAULT_HOST;
	private int port = CONNECT_DEFAULT_PORT;
	private String exchange = CHANNEL_DEFAULT_EXCHANGE;
	private String exchangeType = CHANNEL_DEFAULT_EXCHANGE_TYPE;
	private String routingKey = CHANNEL_DEFAULT_ROUTINGKEY;

	/**
	 * 构造方法需要一个ConnectionInfo对象，包含host、port等
	 * 
	 * @param cacInfo
	 * @throws Exception
	 */
	public ConnectionAndChannels(ConnectionAndChannelsInfo cacInfo) throws Exception {
		if (cacInfo != null) {
			this.host = cacInfo.getHost();
			this.port = cacInfo.getPort();
			this.exchange = cacInfo.getExchange();
			this.exchangeType = cacInfo.getExchangeType();
			this.routingKey = cacInfo.getRoutingKey();
		} 
		init();
	}

	/**
	 * 初始化connection
	 * 
	 * @throws Exception
	 */
	private void init() throws Exception {
		if(connection!=null)connection.close();
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		try {
			connection = factory.newConnection();
		} catch (Exception e) {
			throw new RuntimeException("[ERROR]ConnectionAndChannels.init() failed!", e);
		}
		if (channelPool == null && connection != null) {
			synchronized (initChannelPoolLock) {
				if (channelPool == null && connection != null) {
					channelPool = new ChannelPool(new ChannelPoolConfig(), this);
				}
			}
		}
	}

	/**
	 * 获取channel
	 */
	public Channel getChannel() {
		return channelPool.getResource();
	}
	/**
	 * basicPublish
	 */
	public void basicPublish(String message) {
		 try {
			channelPool.getResource().basicPublish(exchange, routingKey, null, message.getBytes());
		} catch (IOException e) {
			throw new RuntimeException("[ERROR]ConnectionAndChannels.basicPublish() Failed!");
		};
	}

	/**
	 * 管道用完了还回来
	 */
	public void returnChannel(Channel c) {
		channelPool.returnResource(c);
	}
	
	

	/**
	 * 关闭时需要先关闭channelpool再关闭connection
	 */
	public void close() throws IOException {
		if (channelPool != null) {
			channelPool.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
	
	
	

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public Object getInitChannelPoolLock() {
		return initChannelPoolLock;
	}

	public ConnectionAndChannelsInfo getCacInfo() {
		return cacInfo;
	}

	public void setCacInfo(ConnectionAndChannelsInfo cacInfo) {
		this.cacInfo = cacInfo;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ChannelPool getChannelPool() {
		return channelPool;
	}

	public void setChannelPool(ChannelPool channelPool) {
		this.channelPool = channelPool;
	}

}
