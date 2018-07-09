package com.ggstudy.mq.model;


public class ConnectionAndChannelsInfo {

	public static final String CONNECT_DEFAULT_HOST = "localhost";
	public static final int CONNECT_DEFAULT_PORT = 5672;
	public static final String CHANNEL_DEFAULT_EXCHANGE = "default_exchange";
	public static final String CHANNEL_DEFAULT_EXCHANGE_TYPE = "fanout";
	public static final String CHANNEL_DEFAULT_ROUTINGKEY = "";
	
	/**
	 * 链接主机
	 */
	private String host=CONNECT_DEFAULT_HOST;
	/**
	 * 端口
	 */
	private int port=CONNECT_DEFAULT_PORT;
	/**
	 * exchange名
	 */
	private String exchange=CHANNEL_DEFAULT_EXCHANGE;
	/**
	 * exchange类型fanout、direct、topic
	 */
	private String exchangeType=CHANNEL_DEFAULT_EXCHANGE_TYPE;
	/**
	 * routingKey
	 */
	private String routingKey=CHANNEL_DEFAULT_ROUTINGKEY;

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
}
