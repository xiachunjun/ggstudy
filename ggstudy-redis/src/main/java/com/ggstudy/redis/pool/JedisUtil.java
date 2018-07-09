package com.ggstudy.redis.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Administrator
 *         查阅一些网上的资料说JedisPool在只有一个服务时使用，ShardedJedisPool是主、从部署时使用，不确定，有待继续学习
 */
public class JedisUtil {

	private static volatile JedisUtil jedisUtil = null;
	private JedisPool jedisPool = null;// 非切片连接池

	private JedisUtil() {
	}

	/**
	 * 初始化非切片池
	 */
	private void initialPool() {
		String ip = "127.0.0.1";
		String ports = "6379";
		JedisPoolConfig config = getConfig();
		jedisPool = new JedisPool(config, ip, Integer.valueOf(ports));
	}

	private JedisPoolConfig getConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(20);
		config.setMaxTotal(20);
		config.setMaxWaitMillis(100000);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		return config;
	}

	// 这里之后要写成连接池，准备用dbcp2，池的初始化参数也在这设
	public static JedisUtil getJedisUtil() {
		if (null == JedisUtil.jedisUtil) {
			synchronized (JedisUtil.class) {
				if (null == JedisUtil.jedisUtil) {
					JedisUtil.jedisUtil = new JedisUtil();
				}
			}
		}
		return JedisUtil.jedisUtil;
	}

	public Jedis getJedis() {
		if (null == jedisPool) {
			synchronized (JedisUtil.class) {
				if (null == jedisPool) {
					initialPool();
				}
			}
		}
		return jedisPool.getResource();
	}

	/**
	 * 测试一下连接池，查阅源码由于jedisPool的归还资源的方法不再使用，获取连接并使用完毕之后调用close如果是池中连接也是会被归还的。
	 * 现象：两次get出来的是同一个对象（池的大小只设置了1）
	 */
	public static void main(String[] args) {
		new JedisUtil().initialPool();
		Jedis jedis = JedisUtil.getJedisUtil().getJedis();
		jedis.set("aaa", "aaaa");
		jedis.append("aaa", "1aaaa");
		jedis.close();
		jedis = JedisUtil.getJedisUtil().getJedis();
		System.out.println(jedis.get("aaa"));
	}

}
