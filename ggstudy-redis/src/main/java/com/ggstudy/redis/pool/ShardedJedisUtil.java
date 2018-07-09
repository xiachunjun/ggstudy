package com.ggstudy.redis.pool;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class ShardedJedisUtil {
	private static volatile ShardedJedisUtil shardedJedisUtil = null;
	private  ShardedJedisPool shardedJedisPool = null;// 切片连接池

	private ShardedJedisUtil() {
	}

	//这里之后要写成连接池，准备用dbcp2，池的初始化参数也在这设
	public static ShardedJedisUtil getShardedJedisUtil(){
		if(null==ShardedJedisUtil.shardedJedisUtil){
			synchronized(ShardedJedisUtil.class){
				if(null==ShardedJedisUtil.shardedJedisUtil){
					ShardedJedisUtil.shardedJedisUtil=new ShardedJedisUtil();
				}
			}
		}
		return ShardedJedisUtil.shardedJedisUtil;
	}
	
	public ShardedJedis getShardedJedis(){
		if(null==shardedJedisPool){
			synchronized(ShardedJedisUtil.class){
				if(null==shardedJedisPool){
					initialShardedPool();
				}
			}
		}
		return shardedJedisPool.getResource();
	}
	
	/**
	 * 初始化切片池
	 */
	private void initialShardedPool() {
		// 池基本配置
		String ports = "6379";
		String ips = "127.0.0.1";
		String names = "master";
		// slave链接
		JedisPoolConfig config = getConfig();
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		String[] ipsstr = ips.split(";");
		String[] portsstr = ports.split(";");
		String[] namesstr = names.split(";");
		for (int i = 0; i < ipsstr.length; i++) {
			shards.add(new JedisShardInfo(ipsstr[i], Integer.valueOf(portsstr[i]), 5000, namesstr[i]));
		}
		// 构造池
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}
	
	private JedisPoolConfig getConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(10);
		config.setMaxTotal(50);
		config.setMaxWaitMillis(10000);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		return config;
	}

	public static void main(String[] args) {
		ShardedJedis shardedJedis = ShardedJedisUtil.getShardedJedisUtil().getShardedJedis();
		shardedJedis.set("bbb", "ccc");
	}

}
