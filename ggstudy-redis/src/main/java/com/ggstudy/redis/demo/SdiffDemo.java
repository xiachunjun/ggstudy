package com.ggstudy.redis.demo;

import org.junit.Test;

/**
 * @author xcj redis集合操作
 */
public class SdiffDemo extends BaseDemo {
	@Test
	public void sdiffTest() {
		// jedis.sdiff(keys)；
		jedis.sadd("chinaPay", "CNP20180324200000-1090-371703073@qq.com-SH90029-2");
		jedis.sadd("chinaPay", "CNP20180324200001-1091-371703073@qq.com-SH90029-2");
		jedis.sadd("chinaPay", "CNP20180324200002-1092-371703073@qq.com-SH90029-2");
		jedis.sadd("chinaPay", "CNP20180324200003-1092-371703073@qq.com-SH90029-2");
		jedis.sadd("chinaPay-local", "CNP20180324200000-1090-371703073@qq.com-SH90029-2");
		jedis.sadd("chinaPay-local", "CNP20180324200001-1099-371703073@qq.com-SH90029-2");
		jedis.sadd("chinaPay-local", "CNP20180324200002-1090-371703073@qq.com-SH90029-2");
		jedis.sadd("chinaPay-local", "CNP20180324200003-1092-371703073@qq.com-SH90029-2");
		// System.out.println(jedis.smembers("chinaPay"));

		System.out.println(jedis.sdiff("chinaPay", "chinaPay-local"));
		jedis.del("chinaPay");
		jedis.del("chinaPay-local");
	}
}
