package com.ggstudy.redis.demo;

import org.junit.After;
import org.junit.Before;

import redis.clients.jedis.Jedis;

import com.ggstudy.redis.pool.JedisUtil;

public class BaseDemo {
	JedisUtil jedisUtil = null;
	Jedis jedis = null;

	@Before
	public void BeforeJedisPoolTest() {
		jedisUtil = JedisUtil.getJedisUtil();
		jedis = jedisUtil.getJedis();
	}

	@After
	public void AfterJedisPoolTest() {
		jedis.close();
	}
}
